package com.example.diaryproject.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "id 에는 공백이 없어야 합니다.")
    @Size(min = 5)
    private String accountId;

    @NotBlank(message = "password 에는 공백이 없어야 합니다.")
    private String password;

    @NotBlank
    private String name;

    private Long studentId;

}
