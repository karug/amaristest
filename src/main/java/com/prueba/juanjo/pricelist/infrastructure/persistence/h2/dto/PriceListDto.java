package com.prueba.juanjo.pricelist.infrastructure.persistence.h2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRICES_LIST")
@Getter
@Setter
@NoArgsConstructor
public class PriceListDto {

    @Id
    private Long id;
    private String name;
}