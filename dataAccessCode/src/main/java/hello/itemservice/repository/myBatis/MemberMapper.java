package hello.itemservice.repository.myBatis;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * mybatis 매핑 xml을 호출해주는 인터페이스 @Mapper애노테이션을 통해 인식 + 자동으로 스프링 빈에 등록
 * */
@Mapper
public interface MemberMapper {

    void save(Member member);

    void update(@Param("id") Long id, @Param("updateParam") MemberUpdateDto updateParam);

    List<Member> findAll(MemberSearchCond itemSearch);

    Optional<Member> findById(Long id);
}

/**
 * @Param: 파라미터가 2개 이상일 경우 @Param을 붙여야 한다. 큰 의미는 없다.
 * */

