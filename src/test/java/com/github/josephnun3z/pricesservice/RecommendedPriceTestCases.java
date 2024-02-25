package com.github.josephnun3z.pricesservice;

import com.github.josephnun3z.pricesservice.boundary.RecommendedPriceDto;

import java.util.Map;

public final class RecommendedPriceTestCases {

    public static final Map<Integer, RecommendedPriceDto> SUCCESS_TEST_CASES = Map.of(
        1, new RecommendedPriceDto(35455L, 1, 2, 35.50, "EUR"),
        2, new RecommendedPriceDto(35455L, 1, 2, 25.45, "EUR"),
        3, new RecommendedPriceDto(35455L, 1, 1, 35.50, "EUR"),
        4, new RecommendedPriceDto(35455L, 1, 3, 30.50, "EUR"),
        5, new RecommendedPriceDto(35455L, 1, 4, 38.95, "EUR")
    );

}