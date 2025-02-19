package com.ddadak.springbootblog.common.user.repository;

import com.ddadak.springbootblog.common.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
