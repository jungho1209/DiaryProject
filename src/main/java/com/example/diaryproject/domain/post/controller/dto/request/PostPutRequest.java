package com.example.diaryproject.domain.post.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostPutRequest {

    private String content;
    private String title;
}
