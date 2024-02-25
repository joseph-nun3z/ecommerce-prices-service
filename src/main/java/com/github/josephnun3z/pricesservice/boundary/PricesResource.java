package com.github.josephnun3z.pricesservice.boundary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PricesResource {

    @GetMapping("/recommended-price")
    public Mono<ResponseEntity<RecommendedPriceDto>> recommendedPrice(
            @RequestParam("startDate") String startDate,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Integer brandId
    ) {
        return Mono.just(ResponseEntity.ok().build());
    }
}