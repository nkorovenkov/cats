package com.nkor.course.exception.response;

import com.nkor.course.exception.HttpCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Базовый класс сообщение стандартного API ответа
 *
 * @param <D> - тип данных в поле data (тело ответа)
 */
public abstract class AbstractBaseResponseMessage<D> {
    private final boolean isResultSuccess;

    @Getter
    private final HttpCode statusCode;

    @Getter
    @Setter
    private D data;

    public AbstractBaseResponseMessage(boolean isResultSuccess, HttpCode statusCode) {
        this.statusCode = statusCode;
        this.isResultSuccess = isResultSuccess;
    }

    /**
     * Результат выполнения запроса
     *
     * @return true - удачно, false - не удачно
     */
    public boolean getIsResultSuccess() {
        return isResultSuccess;
    }

}

