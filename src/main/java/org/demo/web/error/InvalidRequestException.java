package org.demo.web.error;

import lombok.Getter;

@Getter
public class InvalidRequestException extends RuntimeException {

    private final int code;

    public InvalidRequestException(int code, String message) {
        super(message);
        this.code = code;
    }
}
