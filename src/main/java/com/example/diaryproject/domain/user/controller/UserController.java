package com.example.diaryproject.domain.user.controller;

import com.example.diaryproject.domain.user.controller.dto.request.LoginRequest;
import com.example.diaryproject.domain.user.controller.dto.request.PutRequest;
import com.example.diaryproject.domain.user.controller.dto.request.UserRequest;
import com.example.diaryproject.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;


    // todo 회원 가입 기능
    @PostMapping("/signup")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@Valid @RequestBody UserRequest userRequest) {
        userService.signUp(userRequest);
    }


    // todo 회원 삭제 기능
    @DeleteMapping("/{account-id}")
    public void delete(@PathVariable("account-id") String accountId) {
        userService.delete(accountId);
    }


    // todo 회원 로그인 기능
    @PostMapping("/login")
    public void logIn(@RequestBody LoginRequest loginRequest) {
        userService.logIn(loginRequest);
    }


    // todo 회원 수정 기능
    @PatchMapping("/{account-id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void update(@PathVariable("account-id") String accountId,
                       @RequestBody PutRequest putRequest) {
        userService.update(accountId, putRequest);
    }


}
