package com.ddadak.springbootblog.blog.service;

import com.ddadak.springbootblog.blog.domain.Article;
import com.ddadak.springbootblog.blog.dto.AddArticleRequest;
import com.ddadak.springbootblog.blog.dto.UpdateArticleRequest;
import com.ddadak.springbootblog.blog.repository.BlogRepository;
import com.ddadak.springbootblog.config.error.exception.ArticleNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메소드
    public Article save(AddArticleRequest request, String userName){
        return blogRepository.save(request.toEntity(userName));
    }

    // 블로그 목록 조회
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    // 블로그 상세 조회
    public Article findById(Long id){
        return blogRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);
    }

    // 블로그 글 삭제
    public void delete(Long id){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }

    // 블로그 글 수정
    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;
    }

    // 게시글을 작성한 유저인지 확인
    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!article.getAuthor().equals(userName)) {
            throw new IllegalArgumentException("not authorized");
        }
    }

}
