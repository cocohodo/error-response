package groomthon.sanghyeon.basic.exception;

import groomthon.sanghyeon.basic.common.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;
    private int value = 0;
    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
    public CustomException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
    public CustomException(ErrorCode errorCode, String message,int grade) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.value = grade;
    }

}
