package com.testingTeam.Todo.Entities.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AuthenticationBean {

    private long id;

    private long errorCode;

    private String username;

    private String token;

    private String message;

    private String role;

    public AuthenticationBean(long id, long errorCode, String username, String token, String message, String role) {
        this.id = id;
        this.errorCode = errorCode;
        this.username = username;
        this.token = token;
        this.message = message;
        this.role = role;
    }
}
