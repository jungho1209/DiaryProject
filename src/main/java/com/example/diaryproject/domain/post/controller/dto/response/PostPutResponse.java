package com.example.diaryproject.domain.post.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostPutResponse {

    private String title;
    private String content;

}
