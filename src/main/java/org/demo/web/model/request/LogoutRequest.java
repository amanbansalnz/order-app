package org.demo.web.model.request;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NonNull;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
