package com.prueba.juanjo.brand.infrastructure.persistence.h2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANDS")
@Getter
@Setter
@NoArgsConstructor
public class BrandDto {

    @Id
    private Long id;
    private String name;
}
