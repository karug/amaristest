package com.prueba.juanjo.price.infrastructure.rest;

import com.prueba.juanjo.price.application.PriceService;
import com.prueba.juanjo.price.domain.Price;
import com.prueba.juanjo.price.infrastructure.rest.request.PriceRequestDto;
import com.prueba.juanjo.price.infrastructure.rest.response.PriceResponseDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PriceResponseDto> get(final PriceRequestDto priceRequestDto) {
        Optional<Price> price = service.getPriceWithMorePriorityFiltered(priceRequestDto.getApplicationDate(),
                priceRequestDto.getBrandId(),
                priceRequestDto.getProductId());
        return price.map(p -> ResponseEntity.ok().body(
                PriceResponseDto.create(p.getProduct().getId(), p.getBrand().getId(), p.getPriceList().getId(),
                        p.getStartDate(), p.getEndDate(), p.getPrice()))).orElse(
                ResponseEntity.notFound().build());

    }
}
