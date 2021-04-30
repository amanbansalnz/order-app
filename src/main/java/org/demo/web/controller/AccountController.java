package org.demo.web.controller;

import antlr.Token;
import lombok.extern.slf4j.Slf4j;
import org.demo.core.model.MemberDetails;
import org.demo.core.service.AccountService;
import org.demo.web.model.request.RegisterRequest;
import org.demo.web.model.response.AccountDetailRequest;
import org.demo.web.model.response.AccountDetailResponse;
import org.demo.web.model.response.LivenessSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public AccountDetailResponse getMemberDetails(@RequestHeader(name = "token") String token) {

        log.info("AccountController get member details");

        MemberDetails memberDetails = accountService.getMemberDetails(token);

        AccountDetailResponse accountDetailResponse = new AccountDetailResponse();
        accountDetailResponse.setEmail(memberDetails.getEmail());
        accountDetailResponse.setMemberName(memberDetails.getMemberName());
        accountDetailResponse.setPhoneNumber(memberDetails.getPhoneNumber());

        log.info("AccountController get member details response <<<< with accountDetailResponse={}", accountDetailResponse);

        return accountDetailResponse;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public AccountDetailResponse register(@RequestBody RegisterRequest registerRequest) {

        log.info("AccountController register");

        MemberDetails memberDetails = accountService.register(registerRequest.getMemberName(),
                registerRequest.getPassword(),
                registerRequest.getPhoneNumber(),
                registerRequest.getEmail());

        AccountDetailResponse accountDetailResponse = new AccountDetailResponse();
        accountDetailResponse.setEmail(memberDetails.getEmail());
        accountDetailResponse.setMemberName(memberDetails.getMemberName());
        accountDetailResponse.setPhoneNumber(memberDetails.getPhoneNumber());

        log.info("AccountController register response <<<< with accountDetailResponse={}", accountDetailResponse);

        return accountDetailResponse;
    }
}
