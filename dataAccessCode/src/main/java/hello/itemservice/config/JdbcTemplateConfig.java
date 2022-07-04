package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.jdbctemplate.JdbcTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**Jdbc Config*/
//@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

    private final DataSource dataSource;

//    @Bean
    public JdbcTemplateRepository jdbcTemplateRepository() {
        return new JdbcTemplateRepository(dataSource);
    }

//    @Bean
    public MemberRepository memberRepository() {
        return jdbcTemplateRepository();
    }
}
