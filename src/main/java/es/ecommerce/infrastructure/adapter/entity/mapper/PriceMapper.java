package es.ecommerce.infrastructure.adapter.entity.mapper;

import es.ecommerce.domain.model.Price;
import es.ecommerce.infrastructure.adapter.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
	Price toDomain(PriceEntity priceEntity);
}