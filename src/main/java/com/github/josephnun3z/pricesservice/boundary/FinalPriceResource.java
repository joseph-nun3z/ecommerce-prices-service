package com.github.josephnun3z.pricesservice.boundary;

import com.github.josephnun3z.pricesservice.ancillary.exception.InvalidDateTimeFormatException;
import com.github.josephnun3z.pricesservice.control.FinalPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/final-price")
public class FinalPriceResource {

    private final FinalPriceService finalPriceService;

    public FinalPriceResource(FinalPriceService finalPriceService) {
        this.finalPriceService = finalPriceService;
    }

    @GetMapping
    public Mono<ResponseEntity<FinalPriceDto>> find(@ModelAttribute @Validated FinalPriceRequestDto dto) {
        LocalDateTime parsedDateTime = localDateTimeFrom(dto.getStartDate());
        return finalPriceService.findFinalPriceFor(parsedDateTime, dto.getProductId(), dto.getBrandId())
            .map(ResponseEntity::ok)
            .defaultIfEmpty(notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> save(@RequestBody List<CreatePriceDto> request) {
        return finalPriceService.save(request)
            .thenReturn(new ResponseEntity<>(HttpStatus.ACCEPTED));
    }

    private LocalDateTime localDateTimeFrom(String date) {
        try {
            return LocalDateTime.parse(date);
        } catch (DateTimeParseException ex) {
            throw new InvalidDateTimeFormatException();
        }
    }
}
