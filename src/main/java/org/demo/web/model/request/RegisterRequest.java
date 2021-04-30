package org.demo.web.model.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String memberName;
    private String password;
    private String phoneNumber;
    private String email;
}
