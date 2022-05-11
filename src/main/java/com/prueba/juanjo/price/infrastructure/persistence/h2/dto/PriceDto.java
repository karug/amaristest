package com.prueba.juanjo.price.infrastructure.persistence.h2.dto;

import com.prueba.juanjo.brand.infrastructure.persistence.h2.dto.BrandDto;
import com.prueba.juanjo.price.domain.Currency;
import com.prueba.juanjo.pricelist.infrastructure.persistence.h2.dto.PriceListDto;
import com.prueba.juanjo.product.infrastructure.persistence.h2.dto.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@NoArgsConstructor
public class PriceDto {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    BrandDto brand;
    LocalDateTime startDate;
    LocalDateTime endDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRICE_LIST", nullable = false)
    PriceListDto priceList;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    ProductDto product;
    Integer priority;
    Double price;
    @Enumerated(EnumType.STRING)
    Currency curr;
    @Id
    private Long id;

}
