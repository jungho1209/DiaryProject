package com.example.diaryproject.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    @Size(min = 5)
    private String accountId;

    @NotBlank
    @Size(min = 8 , message = "password 는 8글자 이상에 공백이 없어야합니다")
    private String password;

}
