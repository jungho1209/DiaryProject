package com.example.diaryproject.domain.post.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UploadRequest {


    @Size(max = 30)
    private String title;

    @Size(min = 40)
    private String content;

}
