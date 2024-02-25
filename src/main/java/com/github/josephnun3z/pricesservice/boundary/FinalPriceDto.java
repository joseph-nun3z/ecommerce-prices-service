package com.github.josephnun3z.pricesservice.boundary;

public record FinalPriceDto(
        Long productId,
        Integer brandId,
        Integer priceListId,
        Double finalPrice,
        String currency
) {
}
