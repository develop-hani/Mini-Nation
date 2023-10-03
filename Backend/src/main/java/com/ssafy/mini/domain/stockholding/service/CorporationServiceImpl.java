package com.ssafy.mini.domain.stockholding.service;

import com.ssafy.mini.domain.stockholding.dto.request.CorporationRegisterRequest;
import com.ssafy.mini.domain.stockholding.dto.response.CorporationInfoResponse;
import com.ssafy.mini.domain.stockholding.entity.Corporation;
import com.ssafy.mini.domain.stockholding.mapper.CorporationMapper;
import com.ssafy.mini.domain.stockholding.repository.CorporationRepository;
import com.ssafy.mini.domain.stockholding.dto.response.CorpStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.StockPriceRateResponse;
import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import com.ssafy.mini.global.infra.s3.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CorporationServiceImpl implements CorporationService {

    private final CorporationRepository corporationRepository;
    private final CorporationMapper corporationMapper;

    private final StockService stockService;

    private final S3Service s3Service;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void register(CorporationRegisterRequest corporationRegisterRequest, MultipartFile logo, MultipartFile profile) {
        log.info("Service Layer: register() 진입");
        Corporation corporation = corporationMapper.corporationRegisterRequestToCorporation(corporationRegisterRequest);

        // 새로운 기업 정보 저장
        // 이미지
        String logoUrl = s3Service.upload(logo);
        String profileUrl = s3Service.upload(profile);

        corporation.setImageUrls(logoUrl, profileUrl);
        corporationRepository.save(corporation);

        // 해당 기업의 지난 주가 정보 수집 및 저장
        stockService.initCorpStock(corporation.getStkCd());
    }

    @Override
    public List<CorporationInfoResponse> getCorpInfo() {
        log.info("Service Layer: getCorpList() called");
        // 기업 정보
        List<CorporationInfoResponse> corpInfo = corporationToCorporationInfoResponse(corporationRepository.findAll());

        for (CorporationInfoResponse corporationInfoResponse : corpInfo) {
            // 지난 두달 주가 데이터
            List<CorpStockInfoResponse> stockList = stockService.getStockInfo(corporationInfoResponse.getCode());
            corporationInfoResponse.setStock(stockList);

            try {
                // 어제 주가, 하루 등락률
                Date yesterday = dateFormat.parse(stockList.get(stockList.size() - 1).getTime());
                StockPriceRateResponse yesterdayStock = stockService.getStockInfoByDate(corporationInfoResponse.getCode(), yesterday);
                corporationInfoResponse.setYesterday(yesterdayStock);
            } catch (ParseException e) {
                throw new MNException(ErrorCode.NO_SUCH_STOCK_DATE);
            }
        }

        return corpInfo;
    }

    /** Corporation -> CorporationInfoResponse
     * @param corporations 기업 정보
     * @return
     */
    private List<CorporationInfoResponse> corporationToCorporationInfoResponse(List<Corporation> corporations) {
        return corporations.stream()
                .map(corporationMapper::corporationToCorporationInfoResponse)
                .collect(Collectors.toList());
    }

    /**
     * 7일 전 날짜 구하기
     * @param date
     * @return
     */
    private Date getAWeekAgo(Date date) {
        return new Date(date.getTime() - 7 * 24 * 60 * 60 * 1000);
    }
}
