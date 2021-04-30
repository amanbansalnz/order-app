package org.order.web.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    String memberName;
    String password;
}
