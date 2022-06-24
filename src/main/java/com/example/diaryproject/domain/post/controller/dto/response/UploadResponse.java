package com.example.diaryproject.domain.post.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UploadResponse {

    private final String content;
    private final String title;

}
