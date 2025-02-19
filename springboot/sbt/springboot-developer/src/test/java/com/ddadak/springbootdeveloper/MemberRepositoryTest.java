package com.ddadak.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers(){
        // given
        List<Member> members = memberRepository.findAll();

        // when
        assertThat(members.size()).isEqualTo(3);

        // then
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberById(){
        // given
        Member member = memberRepository.findById(2L).get();

        // when
        assertThat(member.getName()).isEqualTo("B");

        // then
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberByName(){
        // given
        Member member = memberRepository.findByName("C").get();

        // when
        assertThat(member.getId()).isEqualTo(3);

        // then
    }

    @Test
    void saveMember(){
        // given
        Member member = new Member(1L, "A");

        // when
        memberRepository.save(member);

        // then
        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }

    @Test
    void saveMembers(){
        // given
        List<Member> members = List.of(
                new Member(1L, "A"),
                new Member(2L, "B")
        );

        // when
        memberRepository.saveAll(members);

        // then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")
    @Test
    void deleteMemberById(){
        // given

        // when
        memberRepository.deleteById(2L);

        // then
        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }

    @Sql("/insert-members.sql")
    @Test
    void deleteAll(){
        // given

        // when
        memberRepository.deleteAll();

        // then
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/insert-members.sql")
    @Test
    void update(){
        // given
        Member member = memberRepository.findById(2L).get();

        // when
        member.changeName("BC");

        // then
        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }

}