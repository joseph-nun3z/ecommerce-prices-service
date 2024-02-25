package com.github.josephnun3z.pricesservice.boundary;

import com.github.josephnun3z.pricesservice.control.FinalPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
public class FinalPriceResource {

    private final FinalPriceService finalPriceService;

    public FinalPriceResource(FinalPriceService finalPriceService) {
        this.finalPriceService = finalPriceService;
    }

    @GetMapping("/final-price")
    public Mono<ResponseEntity<FinalPriceDto>> recommendedPrice(
            @RequestParam("startDate") String dateTime,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Integer brandId
    ) {
        return finalPriceService.findPrice(
            LocalDateTime.parse(dateTime),
            productId,
            brandId
        ).map(ResponseEntity::ok);
    }
}
