package org.order.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.order.core.service.AuthenticationService;
import org.order.web.error.InvalidRequestException;
import org.order.web.model.request.LoginRequest;
import org.order.web.model.request.LogoutRequest;
import org.order.web.model.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class AuthenticationController {

    @Autowired
    private AuthenticationService authethicationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        log.info("AuthenticationController login");

        String token = authethicationService.authenticate(loginRequest.getMemberName(), loginRequest.getPassword());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);

        log.info("AuthenticationController login response <<<< with loginResponse={}", loginResponse);

        return loginResponse;
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@RequestHeader(name = "token") String token) {

        log.info("AuthenticationController login");

        if(token == null){
            throw new InvalidRequestException(400, "Bad Request");
        }
        authethicationService.logout(token);

        log.info("AuthenticationController login response");
    }
}
