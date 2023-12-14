package groomthon.sanghyeon.basic.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    OK(2000, HttpStatus.OK, "OK"),
    BAD_REQUEST(4000, HttpStatus.BAD_REQUEST, "BAD REQUEST"),
    INTERNAL_SERVER_ERROR(5000, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR");

    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
