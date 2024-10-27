package com.nkor.course.exception;

import com.nkor.course.exception.response.AbstractBaseResponseMessage;
import com.nkor.course.exception.response.FailureResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Глобальная обработка ошибок
 */
@Slf4j
@RestControllerAdvice
public class GlobalErrorControllerAdvice {

    /**
     * Обработка ошибок в общем случае
     */
    @ExceptionHandler(HttpCodeException.class)
    public AbstractBaseResponseMessage<String> handleGlobalExceptions(HttpCodeException ex) {
        log.error("{}: {}", ex.getHttpCode().getStatusCode(), ex.getMessage());

        return new FailureResponseMessage<>(false, ex.getHttpCode(), ex.getMessage());
    }

    /**
     * Обработка ошибок RuntimeException
     */
    @ExceptionHandler(RuntimeException.class)
    public AbstractBaseResponseMessage<String> handleRuntimeException(RuntimeException ex) {
        log.error("{}: {}", HttpCode.SERVER_ERROR_500.getStatusCode(), ex.toString());
        ex.printStackTrace();

        return new FailureResponseMessage<>(false, HttpCode.SERVER_ERROR_500, ex.toString());
    }

    /**
     * Обработка ошибок в самом общем случае
     */
    @ExceptionHandler(Exception.class)
    public AbstractBaseResponseMessage<String> handleRuntimeException(Exception ex) {
        log.error("{}: {}", HttpCode.SERVER_ERROR_500.getStatusCode(), ex.toString());
        ex.printStackTrace();

        return new FailureResponseMessage<>(false, HttpCode.SERVER_ERROR_500, ex.toString());
    }
}
