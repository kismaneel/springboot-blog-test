package com.ddadak.springbootblog.blog.dto;

import com.ddadak.springbootblog.blog.domain.Article;
import com.ddadak.springbootblog.blog.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private String author;
    private List<Comment> comments;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt = article.getCreateAt();
        this.author = article.getAuthor();
        this.comments = article.getComments();
    }
}
