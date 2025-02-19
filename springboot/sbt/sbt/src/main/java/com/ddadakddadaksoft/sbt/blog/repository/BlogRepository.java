package com.ddadakddadaksoft.sbt.blog.repository;

import com.ddadakddadaksoft.sbt.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
