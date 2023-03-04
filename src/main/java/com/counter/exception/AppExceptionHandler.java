package com.counter.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class AppExceptionHandler {

    @ExceptionHandler(NotFoundDirectoryException.class)
    public ResponseEntity<AppMessage> handleNotFoundDirectoryException(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.status(NotFoundDirectoryException.code)
                .body(new AppMessage(NotFoundDirectoryException.code, e.getMessage()));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class AppMessage {
        private Integer code;
        private String message;
    }
}
