package com.charter.rewards.controller;


import com.charter.rewards.controller.error.BadRequestException;
import com.charter.rewards.controller.error.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class BaseRestController {
    @ExceptionHandler(exception = NotFoundException.class)
    protected ResponseEntity<?> handleNotFound(NotFoundException exception) {
        log.error("Encountered not-found error", exception);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(exception = BadRequestException.class)
    protected ResponseEntity<?> handleBadRequest(NotFoundException exception) {
        log.error("Encountered bad-request error", exception);
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
