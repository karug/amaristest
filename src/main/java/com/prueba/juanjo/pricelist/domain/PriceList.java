package com.prueba.juanjo.pricelist.domain;

import lombok.Getter;

@Getter
public class PriceList {

    private Long id;
    private String name;

    private PriceList(Long id) {
        this.setId(id);
    }

    public static PriceList create(Long id) {
        return new PriceList(id);
    }

    private void setId(Long id) {
        this.id = id;
    }
}
