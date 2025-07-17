package com.charter.rewards.controller.error;

public class NotFoundException extends RuntimeException {
    public NotFoundException(final String entityName) {
        super((entityName != null ? entityName : "Resource") + " not found");
    }
}
