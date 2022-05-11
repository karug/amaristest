package com.prueba.juanjo.price.infrastructure.rest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("integration")
class PriceControllerIT {

    private static final String PATH_PRICES = "/prices";
    private static final String PARAM_APPLICATION_DATE = "applicationDate";
    private static final String PARAM_BRAND_ID = "brandId";
    private static final String PARAM_PRODUCT_ID = "productId";
    private static final String FIELD_PRICE = "$.price";
    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "2020-06-14T10:00:00, 1, 35455, 35.5",
            "2020-06-14T16:00:00, 1, 35455, 25.45",
            "2020-06-14T21:00:00, 1, 35455, 35.5",
            "2020-06-15T10:00:00, 1, 35455, 30.5",
            "2020-06-16T21:00:00, 1, 35455, 38.95"
    })
    public void check_correct_price_fiven_date_brand_and_product(String applicationDate,
                                                                 String brandId,
                                                                 String productId,
                                                                 String price) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PATH_PRICES).queryParam(PARAM_APPLICATION_DATE,
                applicationDate).queryParam(PARAM_BRAND_ID,
                brandId).queryParam(
                PARAM_PRODUCT_ID, productId).contentType(MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andExpect(jsonPath(FIELD_PRICE).value(price));
    }
}
