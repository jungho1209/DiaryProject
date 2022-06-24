package com.example.diaryproject.domain.user.service;

import com.example.diaryproject.domain.user.controller.dto.request.LoginRequest;
import com.example.diaryproject.domain.user.controller.dto.request.PutRequest;
import com.example.diaryproject.domain.user.controller.dto.request.UserRequest;
import com.example.diaryproject.domain.user.domain.User;
import com.example.diaryproject.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // todo 회원 가입 기능
    @Transactional
    public void signUp(UserRequest userRequest) {
        if (userRepository.findByAccountId(userRequest.getAccountId()).isPresent()) {
            throw new RuntimeException("이미 존재하는 id 입니다.");
        }

        User user = User.builder()
                .accountId(userRequest.getAccountId())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .name(userRequest.getName())
                .studentId(userRequest.getStudentId())
                .build();
        userRepository.save(user);
    }


    // todo 회원 정보 삭제 기능
    @Transactional
    public void delete(String accountId) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }


    // todo 로그인 기능
    @Transactional
    public void logIn(LoginRequest loginRequest) {

        User user = userRepository.findByAccountId(loginRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("id 가 존재하지 않습니다."));

        if (!passwordEncoder.matches(loginRequest.getPassword(),
                user.getPassword()))
            throw new RuntimeException("password 가 일치하지 않습니다.");
    }


    // todo 회원 정보 수정 기능
    @Transactional
    public void update(String accountId, PutRequest putRequest) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException("id 가 존재하지 않습니다."));
        user.update(passwordEncoder.encode(putRequest.getPassword()),
                putRequest.getAccountId(),
                putRequest.getName());
    }

}
