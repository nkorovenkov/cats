package com.nkor.course.exception.response;

import com.nkor.course.exception.HttpCode;

/**
 * Сообщение стандартного API успешного ответа
 *
 * @param <D> - тип данных в поле data (тело ответа)
 */
public class SuccessResponseMessage<D> extends AbstractBaseResponseMessage<D> {
    public SuccessResponseMessage() {
        super(true, HttpCode.OK_200);
    }

    public SuccessResponseMessage(boolean isResultSuccess, HttpCode statusCode, D data) {
        super(isResultSuccess, statusCode);
        this.setData(data);
    }

    public SuccessResponseMessage(D data) {
        this(true, HttpCode.OK_200, data);
    }

    /**
     * Создает сообщение об успешном выполнении запроса
     *
     * @param statusCode код статуса HTTP
     */
    public SuccessResponseMessage(HttpCode statusCode) {
        super(true, statusCode);
    }
}

