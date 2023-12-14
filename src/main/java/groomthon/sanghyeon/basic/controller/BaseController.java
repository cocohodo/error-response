package groomthon.sanghyeon.basic.controller;

import groomthon.sanghyeon.basic.common.ApiResponse;
import groomthon.sanghyeon.basic.common.ExceptionContext;
import groomthon.sanghyeon.basic.exception.CustomException;
import groomthon.sanghyeon.basic.exception.CustomExceptionV2;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

abstract public class BaseController {
    public <T>ApiResponse<T> makeResponse(T result) {
        return makeResponse(Collections.singletonList(result));
    }
    public <T>ApiResponse<T> makeResponse(List<T> results) {
        return new ApiResponse<>(results);
    }

    @ExceptionHandler(CustomException.class)
    public ApiResponse<Integer> customExceptionHandler (HttpServletResponse response, CustomException exception) {
        response.setStatus(exception.getErrorCode().getHttpStatus().value());
        return new ApiResponse(exception.getErrorCode().getCode(), exception.getMessage(), exception.getValue());
    }
    @ExceptionHandler(CustomExceptionV2.class)
    public ApiResponse<Integer> customExceptionV2Handler (HttpServletResponse response, CustomExceptionV2 exception) {
        response.setStatus(exception.getErrorCode().getHttpStatus().value());
        return new ApiResponse(exception.getErrorCode().getCode(), exception.getMessage(), ExceptionContext.threadLocal.get());
    }
}
