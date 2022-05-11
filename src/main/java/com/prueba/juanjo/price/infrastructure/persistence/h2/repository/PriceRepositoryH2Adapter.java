package com.prueba.juanjo.price.infrastructure.persistence.h2.repository;

import com.prueba.juanjo.price.domain.Price;
import com.prueba.juanjo.price.domain.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryH2Adapter implements PriceRepository {

    private final PriceRepositoryH2 priceRepositoryH2;
    private final ConversionService conversionService;

    @Override
    public List<Price> getPriceWithMorePriority(LocalDateTime applicationDate, Long brandId, Long productId) {
        return priceRepositoryH2.getPriceFilterByApplicationDateBrandAndProduct(applicationDate, brandId,
                productId).stream().map(
                p -> conversionService.convert(p, Price.class)).collect(Collectors.toList());
    }
}
