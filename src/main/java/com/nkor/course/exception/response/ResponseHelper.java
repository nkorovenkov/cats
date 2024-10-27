package com.nkor.course.exception.response;

import com.nkor.course.exception.HttpCode;

/**
 * Класс для создания ответов от сервера
 */
public final class ResponseHelper {
    private ResponseHelper() {
    }

    /**
     * Стандартный успешный ответ от сервера
     *
     * @param <D> Тип данных ответа
     * @return Сообщение успешного ответа
     */
    public static <D> AbstractBaseResponseMessage<D> success() {
        return new SuccessResponseMessage<>();
    }

    /**
     * Стандартный успешный ответ от сервера с указанием кода ответа
     *
     * @param <D> Тип данных ответа
     * @return Сообщение успешного ответа
     */
    public static <D> AbstractBaseResponseMessage<D> success(HttpCode statusCode) {
        return new SuccessResponseMessage<>(statusCode);
    }

    /**
     * Стандартный успешный ответ от сервера с данными в теле
     *
     * @param <D> Тип данных ответа
     * @return Сообщение успешного ответа
     */
    public static <D> AbstractBaseResponseMessage<D> success(D data) {
        return new SuccessResponseMessage<>(data);
    }

    /**
     * Стандартный неуспешный ответ от сервера
     *
     * @param <D> Тип данных ответа
     * @return Сообщение успешного ответа
     */
    public static <D> AbstractBaseResponseMessage<D> fail() {
        return new FailureResponseMessage<>();
    }

    /**
     * Стандартный неуспешный ответ от сервера с указанием кода ответа
     *
     * @param <D> Тип данных ответа
     * @return Сообщение успешного ответа
     */
    public static <D> AbstractBaseResponseMessage<D> fail(HttpCode statusCode) {
        return new FailureResponseMessage<>(statusCode);
    }

    /**
     * Стандартный неуспешный ответ от сервера с телом ответа
     *
     * @param <D> Тип данных ответа
     * @return Сообщение успешного ответа
     */
    public static <D> AbstractBaseResponseMessage<D> fail(D data) {
        return new FailureResponseMessage<>(data);
    }
}
