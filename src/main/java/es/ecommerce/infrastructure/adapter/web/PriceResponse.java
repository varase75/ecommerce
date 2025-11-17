package es.ecommerce.infrastructure.adapter.web;

import java.time.LocalDateTime;

public record PriceResponse(Long productId,
                            Integer brandId,
                            Integer priceList,
                            LocalDateTime startDate,
                            LocalDateTime endDate,
                            Double price,
                            String currency) {
}