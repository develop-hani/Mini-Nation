package com.ssafy.mini.domain.asset.service;

import com.ssafy.mini.domain.account.repository.AccountRepository;
import com.ssafy.mini.domain.asset.entity.Asset;
import com.ssafy.mini.domain.asset.repository.AssetRepository;
import com.ssafy.mini.domain.member.entity.Member;
import com.ssafy.mini.domain.member.repository.MemberRepository;
import com.ssafy.mini.domain.nation.entity.Nation;
import com.ssafy.mini.domain.nation.repository.NationRepository;
import com.ssafy.mini.domain.stockholding.dto.response.PortfolioDto;
import com.ssafy.mini.domain.stockholding.repository.CorporationRepository;
import com.ssafy.mini.domain.stockholding.repository.StockRepository;
import com.ssafy.mini.domain.stockholding.repository.StockholdingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final MemberRepository memberRepository;
    private final NationRepository nationRepository;
    private final AssetRepository assetRepository;
    private final CorporationRepository corporationRepository;
    private final StockRepository stockRepository;
    private final StockholdingRepository stockholdingRepository;
    private final AccountRepository accountRepository;

    /**
     * 모든 회원의 자산 정보 업데이트
     */
    @Override
    @Transactional
    @Scheduled(cron = "0 40 23 * * MON-FRI")
    public void setPersonAssetInfo() {
        log.info("Service Layer: setPersonAssetInfo() called");

        // 각 주식의 가장 최근 가격 정보 가져오기
        Map<String, Integer> currentStockInfo = getStockInfo();

        // 모든 회원 조회하기
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            // 국가 가입이 되지 않은 사람은 건너띄기
            if (member.getIsoSeq() == null) continue;

            int asset = 0;
            asset += myStockAsset(member.getMemId(), currentStockInfo); // 각 회원의 주가 정보
            asset += myBankAsset(member.getMemId()); // 각 회원의 통장 + 예금 + 적금 자산 정보

            // 각 회원의 자산 정보 업데이트
            assetRepository.save(Asset.builder()
                    .member(member)
                    .nation(member.getIsoSeq())
                    .assetDt(new Date())
                    .assetBalance(asset)
                    .build());
        }
    }

    /**
     * 모든 국가의 자산 정보 업데이트
     */
    @Override
    @Transactional
    @Scheduled(cron = "0 50 23 * * MON-FRI")
    public void setNationAssetInfo() {
        log.info("Service Layer: setNationAssetInfo() called");

        // 국가의 정보 가져오기
        List<Nation> nations = nationRepository.findAll();
        for (Nation nation : nations) {
            // 오늘 날짜
            java.sql.Date today = java.sql.Date.valueOf(LocalDate.now());

            // 각 국가의 자산 정보 가져오기
            Integer asset = assetRepository.getNationAccountBalance(nation.getIsoSeq(), today);
            int nationAsset = asset == null ? 0 : asset;

            // 각 국가의 자산 정보 업데이트
            assetRepository.save(Asset.builder()
                    .nation(nation)
                    .assetDt(new Date())
                    .assetBalance(nationAsset)
                    .build());
        }
    }

    /**
     * 각 주식의 코드와 최근 가격
     * key: 종목 코드, value: 최근 가격
     */
    private Map<String, Integer> getStockInfo() {
        // 종목 코드
        List<String> corpCodes = corporationRepository.findAll().stream()
                .map(corp -> corp.getStkCd())
                .collect(Collectors.toList());

        // 각 종목의 최근 가격 정보 가져오기
        return corpCodes
                .stream()
                .collect(Collectors.toMap(
                        code -> code,
                        code -> stockRepository.getstkPriceByStkCd(code)
                ));
    }

    /**
     * 각 회원의 주가 자산 정보
     * @param memberId 회원 아이디
     * @param currentStockInfo 각 주식의 코드와 최근 가격
     */
    private int myStockAsset(String memberId, Map<String, Integer> currentStockInfo) {
        int stockAsset = 0;
        List<PortfolioDto> myPortfolio = stockholdingRepository.findAllByMemberId(memberId);
        for (PortfolioDto myStock : myPortfolio) {
            stockAsset += currentStockInfo.get(myStock.getCode()) * myStock.getHoldQty();
        }
        return stockAsset;
    }

    /**
     * 각 회원의 통장 + 예금 + 적금 자산 정보
     * @param memberId 회원 아이디
     */
    private int myBankAsset(String memberId) {
        Integer bankAsset = accountRepository.getMyAccountBalance(memberId);
        return bankAsset == null ? 0 : bankAsset;
    }

}
