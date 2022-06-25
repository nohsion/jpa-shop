package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() throws Exception {
        //given
        Member member = Member.builder()
                .name("kim")
                .build();

        //when
        Long savedId = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    void 중복_회원_예외() throws Exception {
        //given
        Member member1 = Member.builder()
                .name("kim")
                .build();
        Member member2 = Member.builder()
                .name("kim")
                .build();

        //when
        memberService.join(member1);

        //then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> memberService.join(member2));
//        assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }

}