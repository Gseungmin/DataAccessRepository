package hello.itemservice.DataAccessTest;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * JDBC TEMPLATE
 * MYBATIS
 * JPA
 * Spring Data Jpa
 * Query Dsl
 * */
@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberService memberService;

    @Test
    void RepositoryTest() {
        /**member 저장*/
        Member memberA = new Member("유재석", 26);
        Member memberB = new Member("박명수", 23);
        Member memberC = new Member("정준하", 24);
        Member memberD = new Member("정형돈", 22);
        memberService.save(memberA);
        memberService.save(memberB);
        memberService.save(memberC);
        memberService.save(memberD);

        /**member 조회 by 동적 쿼리*/

        //조건1: 나이가 25살 이하인 member 조회
        MemberSearchCond memberSearchCond1 = new MemberSearchCond();
        memberSearchCond1.setMaxAge(25);
        List<Member> result1 = memberService.findAll(memberSearchCond1);
        Assertions.assertThat(result1.size()).isEqualTo(3);
        result1.stream().forEach(member -> System.out.println("member = " + member.getUsername()));

        //조건2: 이름에 '정'이 들어가면서 나이가 25살 이하인 member 조회
        MemberSearchCond memberSearchCond2 = new MemberSearchCond();
        memberSearchCond2.setUsername("정");
        memberSearchCond2.setMaxAge(25);
        List<Member> result2 = memberService.findAll(memberSearchCond2);
        Assertions.assertThat(result2.size()).isEqualTo(2);
        result2.stream().forEach(member -> System.out.println("member = " + member.getUsername()));

        //조건3: 이름에 '유'가 들어가는 member 조회
        MemberSearchCond memberSearchCond3 = new MemberSearchCond();
        memberSearchCond3.setUsername("유");
        List<Member> result3 = memberService.findAll(memberSearchCond3);
        Assertions.assertThat(result3.size()).isEqualTo(1);
        result3.stream().forEach(member -> System.out.println("member = " + member.getUsername()));

        //조건4: 전체 member 조회
        MemberSearchCond memberSearchCond4 = new MemberSearchCond();
        List<Member> result4 = memberService.findAll(memberSearchCond4);
        Assertions.assertThat(result4.size()).isEqualTo(4);
        result4.stream().forEach(member -> System.out.println("member = " + member.getUsername()));
    }
}
