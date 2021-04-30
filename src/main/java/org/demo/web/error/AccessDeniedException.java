package org.demo.web.error;

import lombok.Getter;

@Getter
public class AccessDeniedException extends RuntimeException {

    private final int code;

    public AccessDeniedException(int code, String message) {
        super(message);
        this.code = code;
    }
}
