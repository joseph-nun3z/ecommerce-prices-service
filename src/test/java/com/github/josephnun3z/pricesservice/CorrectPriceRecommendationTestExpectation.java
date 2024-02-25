package com.github.josephnun3z.pricesservice;

public record CorrectPriceRecommendationTestExpectation(
        String description,
        Float recommendedPrice,
        String brand,
        Long productId
) {
}
