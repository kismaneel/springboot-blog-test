package com.ddadakddadaksoft.sbt.blog.service;

import com.ddadakddadaksoft.sbt.blog.domain.Article;
import com.ddadakddadaksoft.sbt.blog.dto.AddArticleRequest;
import com.ddadakddadaksoft.sbt.blog.dto.UpdateArticleRequest;
import com.ddadakddadaksoft.sbt.blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메소드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // 블로그 게시물 모두 조회
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // 블로그 게시물 조회
    public Article findById(Long id){
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not find: " + id));
    }

    // 블로그 게시물 삭제
    public void delete(Long id){
        blogRepository.deleteById(id);
    }

    // 블로그 게시물 수정
    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not find: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
