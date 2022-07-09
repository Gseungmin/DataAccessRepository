package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.springdatajpa.DataJpaRepository;
import hello.itemservice.repository.springdatajpa.SpringDataJpaRepository;
import hello.itemservice.service.MemberService;
import hello.itemservice.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**spring data jpa Config*/
//@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {

    private final SpringDataJpaRepository springDataJpaRepository;

//    @Bean
//    public DataJpaRepository dataJpaRepository() {
//        return new DataJpaRepository(springDataJpaRepository);
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return dataJpaRepository();
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
