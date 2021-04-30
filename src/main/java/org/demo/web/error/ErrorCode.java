package org.demo.web.error;

public enum ErrorCode {

    APPLICATION_ERROR(0),
    Unauthorized(401);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
