package com.github.josephnun3z.pricesservice.boundary;

public record RecommendedPriceDto(
        Long productId,
        Integer brandId,
        Long priceListId,
        Float recommendedPrice,
        String currency
) {
}
