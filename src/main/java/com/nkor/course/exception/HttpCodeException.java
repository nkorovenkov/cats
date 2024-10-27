package com.nkor.course.exception;

import lombok.Getter;

@Getter
public class HttpCodeException extends RuntimeException {
    private final HttpCode httpCode;

    public HttpCodeException(HttpCode httpCode) {
        super();
        this.httpCode = httpCode;
    }

    public HttpCodeException(HttpCode httpCode, String massage) {
        super(massage);
        this.httpCode = httpCode;
    }
}
