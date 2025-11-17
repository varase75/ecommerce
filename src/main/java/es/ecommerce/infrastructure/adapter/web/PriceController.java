package es.ecommerce.infrastructure.adapter.web;

import es.ecommerce.application.service.PriceUseCase;
import es.ecommerce.infrastructure.adapter.web.mapper.PriceResponseMapper;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
public class PriceController {
	private final PriceUseCase priceUseCase;
	private final PriceResponseMapper mapper;

	public PriceController(PriceUseCase priceUseCase, PriceResponseMapper mapper) {
		this.priceUseCase = priceUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
	public ResponseEntity<PriceResponse> findPrice(
		@Parameter(description = "Application date (format yyyy-MM-dd HH:mm)", example = "2020-06-14 16:00")
		@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime date,
		@Parameter(description = "Product Id", example = "35455")
		@RequestParam("productId") Long productId,
		@Parameter(description = "Brand Id", example = "1")
		@RequestParam(value = "brandId", defaultValue = "1") Integer brandId) {
		return priceUseCase.findPrice(date, productId, brandId)
			.map(mapper::toResponse)
			.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.noContent().build());
	}
}