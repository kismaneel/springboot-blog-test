package com.ddadak.springbootblog.blog.repository;

import com.ddadak.springbootblog.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
