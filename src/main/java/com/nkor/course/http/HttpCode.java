package com.nkor.course.http;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HttpCode {
    OK_200(200),
    BAD_REQUEST_400(400),
    UNAUTHORIZED_401(401),
    FORBIDDEN_403(403),
    NOT_FOUND_404(404),
    CONFLICT_409(409),
    SERVER_ERROR_500(500);
    private final int value;

    HttpCode(int value) {
        this.value = value;
    }

    @JsonValue
    public int getStatusCode() {
        return this.value;
    }
}
