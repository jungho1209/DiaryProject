package com.example.diaryproject.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 5, nullable = false)
    private Long studentId;


    @Builder
    public User(String accountId, String password, String name, Long studentId) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.studentId = studentId;
    }

    public void update(String accountId, String password, String name) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
    }


}
