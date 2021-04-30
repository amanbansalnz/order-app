package org.demo.web.error;

import lombok.Getter;

@Getter
public class UnAuthenticatedException extends RuntimeException {

    private final int code;

    public UnAuthenticatedException(int code, String message) {
        super(message);
        this.code = code;
    }
}
