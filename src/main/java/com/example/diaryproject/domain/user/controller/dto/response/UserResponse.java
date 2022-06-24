package com.example.diaryproject.domain.user.controller.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private final String accountId;
    private final String password;
    private final String name;
    private final Long studentId;

}
