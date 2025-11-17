package es.ecommerce.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.ports.PriceRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements PriceUseCase {
	private final PriceRepositoryPort priceRepositoryPort;

	public PriceService(PriceRepositoryPort priceRepositoryPort) {
		this.priceRepositoryPort = priceRepositoryPort;
	}

	@Override
	public Optional<Price> findPrice(LocalDateTime date, Long productId, Integer brandId) {
		return priceRepositoryPort.findPrices(date, productId, brandId);
	}
}