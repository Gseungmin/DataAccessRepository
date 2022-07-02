package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.myBatis.MemberMapper;
import hello.itemservice.repository.myBatis.MyBatisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**MyBatis Config*/
@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final MemberMapper memberMapper;

    @Bean
    public MemberRepository memberRepository() {
        return new MyBatisRepository(memberMapper);
    }
}
