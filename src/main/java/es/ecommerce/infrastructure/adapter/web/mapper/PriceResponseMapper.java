package es.ecommerce.infrastructure.adapter.web.mapper;

import es.ecommerce.domain.model.Price;
import es.ecommerce.infrastructure.adapter.web.PriceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceResponseMapper {
	PriceResponse toResponse(Price price);
}