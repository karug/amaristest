package com.prueba.juanjo.price.infrastructure.persistence.h2.repository;

import com.prueba.juanjo.price.infrastructure.persistence.h2.dto.PriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepositoryH2 extends JpaRepository<PriceDto, Long> {

    @Query(value = "select p from PriceDto p where :applicationDate between p.startDate and p.endDate and p.brand.id " + "= :brandId and p.product.id = :productId")
    List<PriceDto> getPriceFilterByApplicationDateBrandAndProduct(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("brandId") Long brandId,
            @Param("productId") Long productId);
}
