package com.testingTeam.Todo.Entities.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Exceptions {

    private int errorCode;

    private String errorMessage;
}
