package groomthon.sanghyeon.basic.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter @Setter
public class ApiResponse<T> {
    private Status status;
    private Metadata metadata;
    private List<T> results;

    public ApiResponse(Status status, Metadata metadata, List<T> results) {
        this.status = status;
        this.metadata = metadata;
        this.results = results;
    }

    public ApiResponse(List<T> results) {
        this.results = results;
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metadata = new Metadata(results.size());
    }
    public ApiResponse(int code, String message) {
        this.status = new Status(code, message);
        this.metadata = new Metadata(results.size());
    }
    public ApiResponse(int code, String message,T value) {
        this.status = new Status(code, message);
        this.metadata = new Metadata(results.size());
        this.results = Collections.singletonList(value);
    }
    public ApiResponse(int code, String message,List<T> value) {
        this.status = new Status(code, message);
        this.metadata = new Metadata(results.size());
        this.results = value;
    }

    @Getter @Setter
    private static class Status {
        private int code;
        private String message;
        public Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
    @Getter @Setter
    private static class Metadata {
        private int resultCount = 0;
        public Metadata(int resultCount) {
            this.resultCount = resultCount;
        }
    }
}
