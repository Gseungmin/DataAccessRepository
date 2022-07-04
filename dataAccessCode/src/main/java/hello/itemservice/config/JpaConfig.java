package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.jpa.JpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

//@Configuration
@RequiredArgsConstructor
public class JpaConfig {

    private final EntityManager em;

//    @Bean
    public JpaRepository jpaRepository() {
        return new JpaRepository(em);
    }

//    @Bean
    public MemberRepository memberRepository() {
        return jpaRepository();
    }
}
