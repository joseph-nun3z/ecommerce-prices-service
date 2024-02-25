package com.github.josephnun3z.pricesservice.boundary;

public record RecommendedPriceDto(
        Long productId,
        Integer brandId,
        Integer priceListId,
        Double recommendedPrice,
        String currency
) {
}
