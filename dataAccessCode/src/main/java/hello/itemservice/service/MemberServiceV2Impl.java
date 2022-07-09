package hello.itemservice.service;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import hello.itemservice.repository.querydsl.QueryDslRepository;
import hello.itemservice.repository.springdatajpa.SpringDataJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MemberServiceV2Impl implements MemberService{

    private final SpringDataJpaRepository springDataJpaRepository;
    private final QueryDslRepository queryDslRepository;

    @Override
    public Member save(Member member) {
        return springDataJpaRepository.save(member);
    }

    @Override
    public void update(Long memberId, MemberUpdateDto updateParam) {
        queryDslRepository.update(memberId, updateParam);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return springDataJpaRepository.findById(id);
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        return queryDslRepository.findAll(cond);
    }
}
