package com.ssafy.mini.domain.stockholding.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockholdingMapper {

    StockholdingMapper INSTANCE = Mappers.getMapper(StockholdingMapper.class);

}
