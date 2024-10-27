package com.nkor.course.exception.response;

import com.nkor.course.exception.HttpCode;

/**
 * Сообщение стандартного API не успешного ответа
 *
 * @param <D> - тип данных в поле data (тело ответа)
 */
public class FailureResponseMessage<D> extends AbstractBaseResponseMessage<D> {
    public FailureResponseMessage() {
        super(false, HttpCode.BAD_REQUEST_400);
    }

    public FailureResponseMessage(boolean isResultSuccess, HttpCode statusCode, D data) {
        super(isResultSuccess, statusCode);
        this.setData(data);
    }

    public FailureResponseMessage(D data) {
        this(false, HttpCode.BAD_REQUEST_400, data);
    }

    /**
     * Создает сообщение об успешном выполнении запроса
     *
     * @param statusCode код статуса HTTP
     */
    public FailureResponseMessage(HttpCode statusCode) {
        super(false, statusCode);
    }
}

