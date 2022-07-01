package hello.itemservice.config;

import hello.itemservice.repository.jdbctemplate.MemberRepository;
import hello.itemservice.repository.jdbctemplate.JdbcTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

    private final DataSource dataSource;

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateRepository(dataSource);
    }
}
