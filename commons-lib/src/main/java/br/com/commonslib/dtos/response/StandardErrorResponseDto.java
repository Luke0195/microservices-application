package br.com.commonslib.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Set;

public record StandardErrorResponseDto(
        Instant timestamp,
        Integer status,
        String error,
        String path,
        String exception,
        @JsonProperty("exception_message")
        String exceptionMessage,
        @JsonProperty("field_errors")
        Set<FieldErrorDto> errors) {
}
