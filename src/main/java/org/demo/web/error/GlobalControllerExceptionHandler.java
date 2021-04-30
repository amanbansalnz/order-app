package org.demo.web.error;

import org.demo.web.model.response.GenericErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public GenericErrorResponse handleConversion(ApplicationException ex) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setCode(ex.getCode());
        genericErrorResponse.setMessage(ex.getMessage());
        return genericErrorResponse;
    }

    @ExceptionHandler(UnAuthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  // 409
    public GenericErrorResponse handleConversion401(UnAuthenticatedException ex) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setCode(ex.getCode());
        genericErrorResponse.setMessage(ex.getMessage());
        return genericErrorResponse;// Nothing to do
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)  // 409
    public GenericErrorResponse handleConversion403(AccessDeniedException ex) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setCode(ex.getCode());
        genericErrorResponse.setMessage(ex.getMessage());
        return genericErrorResponse;// Nothing to do
    }


    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 409
    public GenericErrorResponse handleConversion400(InvalidRequestException ex) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setCode(ex.getCode());
        genericErrorResponse.setMessage(ex.getMessage());
        return genericErrorResponse;// Nothing to do
    }
}
