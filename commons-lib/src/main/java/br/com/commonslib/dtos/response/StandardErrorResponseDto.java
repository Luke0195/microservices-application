package br.com.commonslib.dtos.response;

import java.time.Instant;
import java.util.Set;

public record StandardErrorResponseDto(
        Instant timestamp,
        Integer status,
        String error,
        String path,
        String exception,
        Set<FieldErrorDto> errors) {
}
