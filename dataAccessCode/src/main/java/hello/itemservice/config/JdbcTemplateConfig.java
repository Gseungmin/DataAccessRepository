package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.jdbctemplate.JdbcTemplateRepository;
import hello.itemservice.service.MemberService;
import hello.itemservice.service.MemberServiceImpl;
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
//    public JdbcTemplateRepository jdbcTemplateRepository() {
//        return new JdbcTemplateRepository(dataSource);
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return jdbcTemplateRepository();
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
