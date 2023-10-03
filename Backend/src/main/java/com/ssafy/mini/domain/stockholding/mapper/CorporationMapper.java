package com.ssafy.mini.domain.stockholding.mapper;

import com.ssafy.mini.domain.stockholding.dto.request.CorporationRegisterRequest;
import com.ssafy.mini.domain.stockholding.dto.response.CorporationInfoResponse;
import com.ssafy.mini.domain.stockholding.entity.Corporation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CorporationMapper {
    CorporationMapper INSTANCE = Mappers.getMapper(CorporationMapper.class);

    Corporation corporationRegisterRequestToCorporation(CorporationRegisterRequest request);

    @Mapping(source = "stkCd", target = "code")
    @Mapping(source = "incNm", target = "name")
    @Mapping(source = "incDesc", target = "desc")
    @Mapping(source = "reportLink", target = "report")
    @Mapping(source = "productLink", target = "product")
    @Mapping(source = "incLink", target = "inc")
    CorporationInfoResponse corporationToCorporationInfoResponse(Corporation corporation);
}
