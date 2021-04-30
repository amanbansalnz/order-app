package org.demo.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDetails {
    private String memberName;
    private String password;
    private String phoneNumber;
    private String email;
}
