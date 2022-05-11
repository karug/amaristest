package com.prueba.juanjo.product.domain;

import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private String name;

    private Product(Long id) {
        this.setId(id);
    }

    public static Product create(Long id) {
        return new Product(id);
    }

    private void setId(Long id) {
        this.id = id;
    }
}
