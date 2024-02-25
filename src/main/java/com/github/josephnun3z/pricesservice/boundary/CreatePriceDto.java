package com.github.josephnun3z.pricesservice.boundary;

import java.time.LocalDateTime;

public record CreatePriceDto(
    Integer brandId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Integer priceListId,
    Long productId,
    Integer priority,
    Double price,
    String currency
) {
}
