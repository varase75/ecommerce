package es.ecommerce.application.service;

import es.ecommerce.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceUseCase {
    Optional<Price> findPrice(LocalDateTime date, Long productId, Integer brandId);
}
