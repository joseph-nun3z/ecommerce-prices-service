package com.github.josephnun3z.pricesservice.ancillary.exception;

public class InvalidDateTimeFormatException extends RuntimeException{
    public InvalidDateTimeFormatException() {
        super("Invalid date format");
    }
}
