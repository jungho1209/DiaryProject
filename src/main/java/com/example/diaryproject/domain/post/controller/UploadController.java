package com.example.diaryproject.domain.post.controller;


import com.example.diaryproject.domain.post.controller.dto.request.PostPutRequest;
import com.example.diaryproject.domain.post.controller.dto.request.UploadRequest;
import com.example.diaryproject.domain.post.controller.dto.response.PostSearchResponse;
import com.example.diaryproject.domain.post.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class UploadController {

    private final UploadService uploadService;


    // todo 글 upload 기능
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void upLoad(@Valid @RequestBody UploadRequest uploadRequest) {
        uploadService.upLoad(uploadRequest);
    }


    // todo 글 삭제 기능
    @DeleteMapping("/delete/{title}")
    public void delete(@PathVariable("title") String title) {
        uploadService.delete(title);
    }


    // todo 제목으로 글 내용 보기
    @GetMapping("/search/{title}")
    public PostSearchResponse searchPost(@PathVariable("title") String title) {
        return uploadService.searchPost(title);
    }


    // todo 게시글 수정하기
    @PatchMapping("/patch/{title}")
    @ResponseStatus(HttpStatus.CREATED)
    public void upDate(@PathVariable("title") String title,
                       @RequestBody PostPutRequest postPutRequest) {
        uploadService.upDate(title, postPutRequest);
    }

}
