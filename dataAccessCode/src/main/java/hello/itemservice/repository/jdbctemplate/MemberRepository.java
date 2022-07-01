package hello.itemservice.repository.jdbctemplate;

import hello.itemservice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    void update(Long memberId, MemberUpdateDto updateParam);

    Optional<Member> findById(Long id);

    List<Member> findAll(MemberSearchCond cond);

    void delete(String name);

}
