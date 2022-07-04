package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.querydsl.QueryDslRepository;
import hello.itemservice.repository.springdatajpa.DataJpaRepository;
import hello.itemservice.repository.springdatajpa.SpringDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {

    private final EntityManager em;

    @Bean
    public QueryDslRepository queryDslRepository() {
        return new QueryDslRepository(em);
    }

    @Bean
    public MemberRepository memberRepository() {
        return queryDslRepository();
    }
}
