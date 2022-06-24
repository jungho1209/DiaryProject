package com.example.diaryproject.domain.post.service;

import com.example.diaryproject.domain.post.controller.dto.request.PostPutRequest;
import com.example.diaryproject.domain.post.controller.dto.request.UploadRequest;
import com.example.diaryproject.domain.post.controller.dto.response.PostSearchResponse;
import com.example.diaryproject.domain.post.domain.Upload;
import com.example.diaryproject.domain.post.domain.repository.UploadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UploadService {

    private final UploadRepository uploadRepository;


    // todo 게시글 업로드 기능
    @Transactional
    public void upLoad(UploadRequest uploadRequest) {

        Upload upload = Upload.builder()
                .title(uploadRequest.getTitle())
                .content(uploadRequest.getContent())
                .build();
        uploadRepository.save(upload);
    }


    // todo 게시글 삭제 기능
    @Transactional
    public void delete(String title) {

        Upload upload = uploadRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
        uploadRepository.delete(upload);
    }


    // todo 제목으로 글 찾는 기능
    @Transactional(readOnly = true)
    public PostSearchResponse searchPost(String title) {
        Upload upload = uploadRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("이 제목의 글은 존재하지 않습니다."));
        return PostSearchResponse.builder()

                .content(upload.getContent())
                .build();
    }


    // todo 게시글 수정하기
    @Transactional
    public void upDate(String title, PostPutRequest postPutRequest) {

        Upload upload = uploadRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("이 제목의 글은 존재하지 않습니다."));

        upload.update(postPutRequest.getContent(),
                postPutRequest.getTitle());
    }


}
