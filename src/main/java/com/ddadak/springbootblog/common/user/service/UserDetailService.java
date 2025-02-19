package com.ddadak.springbootblog.common.user.service;

import com.ddadak.springbootblog.config.jwt.TokenProvider;
import com.ddadak.springbootblog.common.jwt.repository.RefreshTokenRepository;
import com.ddadak.springbootblog.common.user.domain.User;
import com.ddadak.springbootblog.common.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public User loadUserByUsername(String email){
        User loginUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(email));

//        String token = tokenProvider.generateToken(loginUser, Duration.ofDays(14));
//        System.out.println("○ token: " + token);
//
//        refreshTokenRepository.save(
//                new RefreshToken(loginUser.getId(), token)
//        );

        return loginUser;
    }

}
