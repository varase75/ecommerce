package es.ecommerce.infrastructure.adapter.web;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PriceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final static String PRODUCT_ID = "35455";
    private final static String BRAND_ID = "1";

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void shouldReturnPriceForGivenProductAndDate1() throws Exception {
        mockMvc.perform(
            get("/price")
                    .param("productId", PRODUCT_ID)
                    .param("brandId", BRAND_ID)
                    .param("date", "2020-06-14T10:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }


    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void shouldReturnPriceForGivenProductAndDate2() throws Exception {
        mockMvc.perform(
            get("/price")
                    .param("productId", PRODUCT_ID)
                    .param("brandId", BRAND_ID)
                    .param("date", "2020-06-14T16:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void shouldReturnPriceForGivenProductAndDate3() throws Exception {
        mockMvc.perform(
            get("/price")
                    .param("productId", PRODUCT_ID)
                    .param("brandId", BRAND_ID)
                    .param("date", "2020-06-14T21:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void shouldReturnPriceForGivenProductAndDate4() throws Exception {
        mockMvc.perform(
            get("/price")
                    .param("productId", PRODUCT_ID)
                    .param("brandId", BRAND_ID)
                    .param("date", "2020-06-15T10:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.price").value(30.5))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void shouldReturnPriceForGivenProductAndDate5() throws Exception {
        mockMvc.perform(
            get("/price")
                    .param("productId", PRODUCT_ID)
                    .param("brandId", BRAND_ID)
                    .param("date", "2020-06-16T21:00:00")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("Price not found")
    void shouldReturn404WhenPriceNotFound() throws Exception {
        mockMvc.perform(
            get("/price")
                    .param("productId", "99999")
                    .param("brandId", BRAND_ID)
                    .param("date", "2020-06-14T10:00:00")
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}