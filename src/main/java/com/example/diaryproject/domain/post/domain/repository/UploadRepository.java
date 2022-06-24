package com.example.diaryproject.domain.post.domain.repository;

import com.example.diaryproject.domain.post.domain.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {


    Optional<Upload> findByTitle(String title);

}
