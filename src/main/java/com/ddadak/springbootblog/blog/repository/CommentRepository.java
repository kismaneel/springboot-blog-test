package com.ddadak.springbootblog.blog.repository;

import com.ddadak.springbootblog.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
