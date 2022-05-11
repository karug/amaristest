package com.prueba.juanjo.price.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> getPriceWithMorePriority(LocalDateTime applicationDate, Long productId, Long brandId);

}
