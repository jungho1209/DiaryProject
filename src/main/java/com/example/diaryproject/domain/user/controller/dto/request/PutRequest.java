package com.example.diaryproject.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PutRequest {

    private String accountId;
    private String password;
    private String name;

}
