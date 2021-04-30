package org.demo.core.service;

import lombok.extern.slf4j.Slf4j;
import org.demo.core.model.MemberDetails;
import org.demo.web.error.AccessDeniedException;
import org.demo.web.error.ApplicationException;
import org.demo.web.error.UnAuthenticatedException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.demo.util.HelperUtil.generateHash;

@Service
@Slf4j
public class AuthenticationService {

    private static Map<String, MemberDetails> authenticationMap;

    public AuthenticationService() {
        authenticationMap = new HashMap<>();
    }

    public String authenticate(String memberName, String password) {

        String key = generateHash(memberName+password);

        if (AccountService.getMemberDetailMap().containsKey(key)) {
            if (memberName != null && memberName.contains("userdemo") && password != null && password.contains("demo")) {
                authenticationMap.put(key, AccountService.getMemberDetailMap().get(key));
            } else {
                log.info("Member not logged in {}", memberName);
                throw new UnAuthenticatedException(401, "Invalid Creds");
            }
        }else {
            log.info("Member not logged in {}", memberName);
            throw new UnAuthenticatedException(401, "Invalid Creds");
        }

        return key;
    }

    public MemberDetails validateIsLoggedIn(String token) {
        if(authenticationMap.containsKey(token)) {
            return authenticationMap.get(token);
        }else{
            throw new AccessDeniedException(403, "Access Denied");
        }
    }

    public void logout(String token) {
        validateIsLoggedIn(token);
        authenticationMap.remove(token);
    }
}
