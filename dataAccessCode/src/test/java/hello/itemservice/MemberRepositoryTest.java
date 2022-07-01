package hello.itemservice;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.jdbctemplate.MemberRepository;
import hello.itemservice.repository.jdbctemplate.MemberSearchCond;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void JDBCTemplate테스트() {
        /**member 저장*/
        Member memberA = new Member("memberA", 26);
        Member memberB = new Member("memberB", 23);
        Member memberC = new Member("memC", 24);
        memberRepository.save(memberA);
        memberRepository.save(memberB);
        memberRepository.save(memberC);

        /**member 조회 by 동적 쿼리*/
        MemberSearchCond memberSearchCond = new MemberSearchCond();

        //조건1: 나이가 25살 이하인 member 조회
        memberSearchCond.setMaxAge(25);
        List<Member> result1 = memberRepository.findAll(memberSearchCond);
        Assertions.assertThat(result1.size()).isEqualTo(2);

        //조건2: 이름에 member가 들어가면서 나이가 25살 이하인 member 조회
        memberSearchCond.setUsername("member");
        memberSearchCond.setMaxAge(25);
        List<Member> result2 = memberRepository.findAll(memberSearchCond);
        Assertions.assertThat(result2.size()).isEqualTo(1);

        /**member 초기화*/
        memberRepository.delete("memberA");
        memberRepository.delete("memberB");
        memberRepository.delete("memC");
    }
}