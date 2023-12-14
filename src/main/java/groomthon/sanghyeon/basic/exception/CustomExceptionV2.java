package groomthon.sanghyeon.basic.exception;

import groomthon.sanghyeon.basic.common.ErrorCode;
import groomthon.sanghyeon.basic.common.ExceptionContext;
import lombok.Getter;
import org.springframework.util.StringUtils;


public class CustomExceptionV2 extends RuntimeException {
    @Getter
    private final ErrorCode errorCode;
    private String message;

    @Override
    public String getMessage() {
        if(StringUtils.hasLength(this.message)) {
            return this.message;
        }
        return errorCode.getMessage();
    }

    public CustomExceptionV2(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public CustomExceptionV2(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public CustomExceptionV2(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        ExceptionContext.threadLocal.get().put(data.getClass().getSimpleName(), data);
    }
}
