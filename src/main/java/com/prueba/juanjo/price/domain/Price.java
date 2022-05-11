package com.prueba.juanjo.price.domain;

import com.prueba.juanjo.brand.domain.Brand;
import com.prueba.juanjo.pricelist.domain.PriceList;
import com.prueba.juanjo.product.domain.Product;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Price {

    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private PriceList priceList;
    private Product product;
    private Integer priority;
    private Double price;
    private Currency curr;

    private Price(Brand brand,
                  LocalDateTime startDate,
                  LocalDateTime endDate,
                  PriceList priceList,
                  Product product,
                  Integer priority,
                  Double price,
                  Currency curr) {
        this.setBrand(brand);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setPriceList(priceList);
        this.setProduct(product);
        this.setPriority(priority);
        this.setPrice(price);
        this.setCurr(curr);
    }

    public static Price create(Long brandId,
                               LocalDateTime startDate,
                               LocalDateTime endDate,
                               Long priceListId,
                               Long productId,
                               Integer priority,
                               Double price,
                               Currency curr) {
        return new Price(Brand.create(brandId), startDate, endDate, PriceList.create(priceListId),
                Product.create(productId), priority, price, curr);

    }

    private void setBrand(Brand brand) {
        this.brand = brand;
    }

    private void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    private void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    private void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    private void setPriority(Integer priority) {
        this.priority = priority;
    }

    private void setPrice(Double price) {
        this.price = price;
    }

    private void setCurr(Currency curr) {
        this.curr = curr;
    }
}
