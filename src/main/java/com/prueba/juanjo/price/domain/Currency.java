package com.prueba.juanjo.price.domain;

public enum Currency {
    EUR("EUR"),
    USD("USD");

    private String value;

    Currency(String value) {
        this.value = value;
    }
}
