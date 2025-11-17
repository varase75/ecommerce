package es.ecommerce.infrastructure.adapter.repository;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.ports.PriceRepositoryPort;
import es.ecommerce.infrastructure.adapter.entity.mapper.PriceMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort  {
    private final JpaPriceRepository jpaRepository;
    private final PriceMapper mapper;

    public PriceRepositoryAdapter(JpaPriceRepository jpaRepository, PriceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Price> findPrices(LocalDateTime date, Long productId, Integer brandId) {
        return jpaRepository.findPrices(date, productId, brandId)
            .stream().findFirst()
            .map(mapper::toDomain);
    }
}