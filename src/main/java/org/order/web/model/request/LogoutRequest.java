package org.order.web.model.request;

import javax.validation.constraints.NotNull;


public class LogoutRequest {
    @NotNull
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
