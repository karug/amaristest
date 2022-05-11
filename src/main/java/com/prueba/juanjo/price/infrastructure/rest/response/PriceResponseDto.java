package com.prueba.juanjo.price.infrastructure.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class PriceResponseDto implements Serializable {

    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("brandId")
    private Long brandId;
    @JsonProperty("priceListId")
    private Long priceListId;
    @JsonProperty("startDate")
    private LocalDateTime startDate;
    @JsonProperty("endDate")
    private LocalDateTime endDate;
    @JsonProperty("price")
    private Double price;

    private PriceResponseDto(Long productId,
                             Long brandId,
                             Long priceListId,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             Double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceListId = priceListId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public static PriceResponseDto create(Long productId,
                                          Long brandId,
                                          Long priceListId,
                                          LocalDateTime startDate,
                                          LocalDateTime endDate,
                                          Double price) {
        return new PriceResponseDto(productId, brandId, priceListId, startDate, endDate, price);
    }
}
