package com.prueba.juanjo.product.infrastructure.persistence.h2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    @Id
    private Long id;
    private String name;
}
