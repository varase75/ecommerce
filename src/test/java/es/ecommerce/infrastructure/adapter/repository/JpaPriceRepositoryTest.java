package es.ecommerce.infrastructure.adapter.repository;

import es.ecommerce.infrastructure.adapter.entity.PriceEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class JpaPriceRepositoryTest {
    @Autowired
    private JpaPriceRepository jpaRepository;

    private final static Long PRODUCT_ID = 35455L;
    private final static Integer BRAND_ID = 1;

    @Test
    @DisplayName("Should return price")
    void shouldFindPrices() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        List<PriceEntity> prices = jpaRepository.findPrices(date, PRODUCT_ID, BRAND_ID);

        assertNotNull(prices);
        assertFalse(prices.isEmpty());
        for (PriceEntity price : prices) {
            assertNotNull(price.getBrandId());
            assertNotNull(price.getProductId());
            assertNotNull(price.getPriceList());
            assertEquals(35.50, price.getPrice());
            assertEquals("EUR", price.getCurrency());
        }
    }

    @Test
    @DisplayName("Should return empty list")
    void shouldReturnEmptyPriceList() {
        LocalDateTime date = LocalDateTime.of(2025, 6, 14, 10, 0, 0);

        List<PriceEntity> prices = jpaRepository.findPrices(date, PRODUCT_ID, BRAND_ID);

        assertNotNull(prices);
        assertTrue(prices.isEmpty());
    }
}