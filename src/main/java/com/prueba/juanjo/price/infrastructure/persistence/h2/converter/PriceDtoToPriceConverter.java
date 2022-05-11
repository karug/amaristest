package com.prueba.juanjo.price.infrastructure.persistence.h2.converter;

import com.prueba.juanjo.price.domain.Price;
import com.prueba.juanjo.price.infrastructure.persistence.h2.dto.PriceDto;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper
public interface PriceDtoToPriceConverter extends Converter<PriceDto, Price> {

    @Override
    default Price convert(PriceDto priceDto) {
        return Price.create(priceDto.getBrand().getId(), priceDto.getStartDate(), priceDto.getEndDate(),
                priceDto.getPriceList().getId(), priceDto.getProduct().getId(), priceDto.getPriority(),
                priceDto.getPrice(), priceDto.getCurr());
    }
}
