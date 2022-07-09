package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.jpa.JpaRepository;
import hello.itemservice.service.MemberService;
import hello.itemservice.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**Jpa Config*/
//@Configuration
@RequiredArgsConstructor
public class JpaConfig {

    private final EntityManager em;

//    @Bean
//    public JpaRepository jpaRepository() {
//        return new JpaRepository(em);
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return jpaRepository();
//    }
//
//    @Bean
//    public MemberServiceImpl memberServiceImpl() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    @Bean
//    public MemberService memberService() {
//        return memberServiceImpl();
//    }
}
