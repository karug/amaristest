package com.prueba.juanjo.price.infrastructure.persistence.h2.converter;

import com.prueba.juanjo.price.domain.Price;
import com.prueba.juanjo.price.infrastructure.persistence.h2.dto.PriceDto;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface PriceToPriceDtoConverter extends Converter<Price, PriceDto> {

    @Override
    PriceDto convert(Price priceo);
}
