package es.ecommerce.domain.ports;

import es.ecommerce.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findPrices(LocalDateTime date, Long productId, Integer brandId);
}
