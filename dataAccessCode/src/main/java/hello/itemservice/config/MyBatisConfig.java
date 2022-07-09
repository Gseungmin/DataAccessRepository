package hello.itemservice.config;

import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.myBatis.MemberMapper;
import hello.itemservice.repository.myBatis.MyBatisRepository;
import hello.itemservice.service.MemberService;
import hello.itemservice.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**MyBatis Config*/
//@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final MemberMapper memberMapper;

//    @Bean
//    public MyBatisRepository myBatisRepository() {
//        return new MyBatisRepository(memberMapper);
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return myBatisRepository();
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
