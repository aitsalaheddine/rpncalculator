package com.cacib.application.adapters.rest.exception.model;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ApplicationError(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
}
