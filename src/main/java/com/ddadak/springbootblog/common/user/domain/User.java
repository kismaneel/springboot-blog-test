package com.ddadak.springbootblog.common.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Builder
    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    // 사용자 이름 변경
    public User update(String nickname){
        this.nickname = nickname;

        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    // 계정 만료 여부
    public boolean isAccountNonExpired() {
        return true;    // true : 만료되지 않았음
    }

    @Override
    // 계정 잠금 여부
    public boolean isAccountNonLocked() {
        return true;    // true : 잠금되지 않았음
    }

    @Override
    // 패스워드 만료 여부
    public boolean isCredentialsNonExpired() {
        return true;    // true : 만료되지 않았음
    }

    @Override
    // 계정 사용 가능 여부
    public boolean isEnabled() {
        return true;    // 사용 가능
    }
}
