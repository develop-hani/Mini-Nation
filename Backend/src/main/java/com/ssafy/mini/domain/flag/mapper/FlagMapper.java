package com.ssafy.mini.domain.flag.mapper;

import com.ssafy.mini.domain.flag.entity.Flag;
import com.ssafy.mini.domain.nation.dto.response.AllFlagResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlagMapper {
    FlagMapper INSTANCE = Mappers.getMapper(FlagMapper.class);

    @Mapping(source = "flagUrl", target = "flag")
    @Mapping(source = "checkedFlagUrl", target = "checkedFlag")
    AllFlagResponse flagToAllFlagResponse(Flag flag);
}
