package com.example.diaryproject.domain.post.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String title;

    @Builder
    public Upload(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public void update(String content, String title) {
        this.content = content;
        this.title = title;

    }

}
