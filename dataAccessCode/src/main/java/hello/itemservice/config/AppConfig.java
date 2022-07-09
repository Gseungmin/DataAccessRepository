package hello.itemservice.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.repository.querydsl.QueryDslRepository;
import hello.itemservice.repository.springdatajpa.SpringDataJpaRepository;
import hello.itemservice.service.MemberService;
import hello.itemservice.service.MemberServiceV2Impl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final EntityManager em;
    private final SpringDataJpaRepository springDataJpaRepository;

    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(em);
    }

    @Bean
    public QueryDslRepository queryDslRepository() {
        return new QueryDslRepository(em, queryFactory());
    }


    @Bean
    public MemberServiceV2Impl memberServiceV2Impl() {
        return new MemberServiceV2Impl(springDataJpaRepository, queryDslRepository());
    }

    @Bean
    public MemberService memberService() {
        return memberServiceV2Impl();
    }
}
