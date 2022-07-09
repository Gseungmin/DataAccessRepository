package hello.itemservice.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.querydsl.QueryDslRepository;
import hello.itemservice.repository.springdatajpa.DataJpaRepository;
import hello.itemservice.repository.springdatajpa.SpringDataJpaRepository;
import hello.itemservice.service.MemberService;
import hello.itemservice.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**query dsl Config*/
//@Configuration
//@RequiredArgsConstructor
public class QueryDslConfig {

//    private final EntityManager em;
//
//    public JPAQueryFactory queryFactory() {
//        return new JPAQueryFactory(em);
//    }
//
//    @Bean
//    public QueryDslRepository queryDslRepository() {
//        return new QueryDslRepository(em, queryFactory());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return queryDslRepository();
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
