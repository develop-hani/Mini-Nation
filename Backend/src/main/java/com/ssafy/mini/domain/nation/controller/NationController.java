package com.ssafy.mini.domain.nation.controller;

import com.ssafy.mini.domain.nation.dto.request.CheckPresidentRequest;
import com.ssafy.mini.domain.nation.dto.request.NationCreateRequest;
import com.ssafy.mini.domain.nation.dto.request.NationSearchRequest;
import com.ssafy.mini.domain.nation.service.NationService;
import com.ssafy.mini.global.auth.jwt.JwtProvider;
import com.ssafy.mini.global.response.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/nation")
@RequiredArgsConstructor
public class NationController {

    private final NationService nationService;

    private final JwtProvider jwtProvider;

    @PostMapping("/create")
    @ApiOperation(value = "국가 생성")
    @ApiResponses({
            @ApiResponse(code = 200, message = "국가 생성 성공"),
            @ApiResponse(code = 404, message = "국가 생성 실패"),
            @ApiResponse(code = 409, message = "이미 생성한 국가 존재")
    })
    public SuccessResponse create(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                                  @RequestBody @ApiParam(value = "국가 생성 정보", required = true) NationCreateRequest nationCreateRequest) {
        log.info("Nation Controller Layer:: create() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        nationService.create(memberId, nationCreateRequest);
        return SuccessResponse.builder()
                .build();
    }

    @PostMapping("/search")
    @ApiOperation(value = "국가 검색")
    @ApiResponses({
            @ApiResponse(code = 200, message = "국가 검색 성공"),
            @ApiResponse(code = 404, message = "국가 검색 실패")
    })
    public SuccessResponse search(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                                  @RequestBody @ApiParam(value = "국가 검색 정보", required = true) NationSearchRequest nationSearchRequest) {
        log.info("Nation Controller Layer::search() called");

        String nationName = nationSearchRequest.getNationName();

        nationService.search(nationName);

        return SuccessResponse.builder()
                .build();
    }

    @PostMapping("/join")
    @ApiOperation(value = "국가 가입")
    @ApiResponses({
            @ApiResponse(code = 200, message = "국가 가입 성공"),
            @ApiResponse(code = 404, message = "국가 가입 실패"),
            @ApiResponse(code = 409, message = "이미 가입한 국가")
    })
    public SuccessResponse join(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                                @RequestBody @ApiParam(value = "국가 가입 정보", required = true) NationSearchRequest nationSearchRequest) {
        log.info("Nation Controller Layer::join() called");

        String memberId = jwtProvider.extractMemberId(accessToken);
        String nationName = nationSearchRequest.getNationName();

        nationService.join(memberId, nationName);

        return SuccessResponse.builder()
                .build();
    }

    @GetMapping("/flag/list")
    @ApiOperation(value = "국기 리스트")
    @ApiResponses({
            @ApiResponse(code = 200, message = "국기 리스트 조회 성공"),
            @ApiResponse(code = 404, message = "국기 리스트 조회 실패")
    })
    public SuccessResponse flagList(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken) {
        log.info("Nation Controller Layer::flagList() called");

        return SuccessResponse.builder()
                .data(nationService.flagList())
                .build();
    }

    @GetMapping("/flags")
    @ApiOperation(value = "국기 리스트")
    @ApiResponses({
            @ApiResponse(code = 200, message = "국기 리스트 조회 성공"),
            @ApiResponse(code = 404, message = "국기 리스트 조회 실패")
    })
    public SuccessResponse listAllFlags(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken) {
        log.info("Nation Controller Layer::listAllFlags() called");

        return SuccessResponse.builder()
                .data(nationService.listAllFlags())
                .build();
    }

    @PostMapping("/nation/president")
    @ApiOperation(value = "국가 대통령 이름 확인")
    @ApiResponses({
            @ApiResponse(code = 200, message = "국가 대통령 이름 확인 성공"),
            @ApiResponse(code = 400, message = "국가 대통령 이름 불일치"),
            @ApiResponse(code = 404, message = "일시적 오류")
    })
    public SuccessResponse president(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                                     @RequestBody @ApiParam(value = "국가 가입 정보", required = true) CheckPresidentRequest checkPresidentRequest) {
        log.info("Nation Controller Layer::checkPresident() called");

        String nationName = checkPresidentRequest.getNation();
        String president = checkPresidentRequest.getPresident();

        nationService.checkPresident(nationName, president);

        return SuccessResponse.builder()
                .build();
    }

}
