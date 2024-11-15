package edu.isaque.todotool.dto.error;

public record FieldMessage(
        String fieldName, String message
) {
}
