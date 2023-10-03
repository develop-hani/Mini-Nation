package com.ssafy.mini.domain.stockholding.mapper;

import com.ssafy.mini.domain.stockholding.entity.Stock;
import com.ssafy.mini.global.feign.stockInfo.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    @Mapping(source = "basDt", target = "stkDt")
    @Mapping(source = "clpr", target = "stkPrice")
    @Mapping(source = "fltRt", target = "stkRate")
    Stock stockItemToStock(Item request);
}
