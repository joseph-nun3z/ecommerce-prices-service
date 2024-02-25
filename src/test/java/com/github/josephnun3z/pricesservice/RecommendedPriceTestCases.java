package com.github.josephnun3z.pricesservice;

import com.github.josephnun3z.pricesservice.boundary.FinalPriceDto;

import java.util.Map;

import static com.github.josephnun3z.pricesservice.FinalPriceDtoBuilder.builder;

public final class RecommendedPriceTestCases {

    public static final Map<Integer, FinalPriceDto> SUCCESS_TEST_CASES = Map.of(
        1, builder().with($ -> { $.productId = 35455L; $.brandId = 1; $.priceListId = 1; $.finalPrice = 35.50; $.currency = "EUR"; }).build(),
        2, builder().with($ -> { $.productId = 35455L; $.brandId = 2; $.priceListId = 2; $.finalPrice = 25.45; $.currency = "EUR"; }).build(),
        3, builder().with($ -> { $.productId = 35455L; $.brandId = 1; $.priceListId = 1; $.finalPrice = 35.50; $.currency = "EUR"; }).build(),
        4, builder().with($ -> { $.productId = 35455L; $.brandId = 3; $.priceListId = 3; $.finalPrice = 30.50; $.currency = "EUR"; }).build(),
        5, builder().with($ -> { $.productId = 35455L; $.brandId = 4; $.priceListId = 4; $.finalPrice = 38.95; $.currency = "EUR"; }).build()
    );

}
