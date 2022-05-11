package com.prueba.juanjo.brand.domain;

import lombok.Getter;

@Getter
public class Brand {

    private Long id;
    private String name;

    private Brand(Long id) {
        this.setId(id);
    }

    public static Brand create(Long id) {
        return new Brand(id);
    }

    private void setId(Long id) {
        this.id = id;
    }

}
