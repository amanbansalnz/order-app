package org.order.core.service;

import lombok.extern.slf4j.Slf4j;
import org.order.core.model.MemberDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.order.util.HelperUtil.generateHash;

@Service
@Slf4j
public class AccountService {

    private static Map<String, MemberDetails> memberDetailMap;

    @Autowired
    AuthenticationService authenticationService;

    public AccountService(){
        memberDetailMap = new HashMap<>();
    }

    public MemberDetails register(String memberName, String password, String phoneNumber, String email){
        MemberDetails memberDetails = null;
        String token = generateHash(memberName+password);
        if(!memberDetailMap.containsKey(token)){
            memberDetails =  new MemberDetails(memberName, password, phoneNumber, email);
            memberDetailMap.put(token, memberDetails);
        }else{
            log.info("Member already registered {}", memberName);
        }

        return memberDetails;
    }


    public static Map<String, MemberDetails> getMemberDetailMap() {
        return memberDetailMap;
    }

    public MemberDetails getMemberDetails(String token) {
       return authenticationService.validateIsLoggedIn(token);
    }
}
