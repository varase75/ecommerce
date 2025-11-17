package es.ecommerce.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import es.ecommerce.domain.model.Price;
import es.ecommerce.domain.ports.PriceRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceServiceTest {
	private PriceUseCase service;
	@Mock
	private PriceRepositoryPort priceRepositoryPort;

	private final static Long PRODUCT_ID = 35455L;
	private final static Integer BRAND_ID = 1;

	@BeforeEach
	void setUp() {
		service = new PriceService(priceRepositoryPort);
	}

	@Test
	@DisplayName("Should return price")
	public void shouldReturnPriceForGivenProductAndDate() {
		LocalDateTime date = LocalDateTime.now();
		Long productId = PRODUCT_ID;
		Integer brandId = BRAND_ID;

		Price price = new Price(BRAND_ID, PRODUCT_ID, 2, LocalDateTime.now(), LocalDateTime.now(), 100d, "EUR");
		when(priceRepositoryPort.findPrices(any(LocalDateTime.class), anyLong(), anyInt()))
			.thenReturn(Optional.of(price));

		Optional<Price> result = service.findPrice(date, productId, brandId);
		assertTrue(result.isPresent());
	}

	@Test
	@DisplayName("Should Not return price")
	public void shouldNotReturnPriceForGivenProductAndDate() {
		LocalDateTime date = LocalDateTime.now();
		Long productId = PRODUCT_ID;
		Integer brandId = BRAND_ID;

		Optional<Price> result = service.findPrice(date, productId, brandId);
		assertFalse(result.isPresent());
	}
}