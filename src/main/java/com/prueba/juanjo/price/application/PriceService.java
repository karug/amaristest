package com.prueba.juanjo.price.application;

import com.prueba.juanjo.price.domain.Price;
import com.prueba.juanjo.price.domain.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository repository;

    public PriceService(PriceRepository repository) {
        this.repository = repository;
    }

    public Optional<Price> getPriceWithMorePriorityFiltered(LocalDateTime applicationDate,
                                                            Long brandId,
                                                            Long productId) {
        return repository.getPriceWithMorePriority(applicationDate, brandId, productId).stream().max(
                Comparator.comparing(Price::getPriority));
    }
}
