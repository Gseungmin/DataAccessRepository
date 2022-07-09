package hello.itemservice.service;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * MemberService Interface
 * **/
public interface MemberService {

    Member save(Member member);

    void update(Long memberId, MemberUpdateDto updateParam);

    Optional<Member> findById(Long id);

    List<Member> findAll(MemberSearchCond cond);
}
