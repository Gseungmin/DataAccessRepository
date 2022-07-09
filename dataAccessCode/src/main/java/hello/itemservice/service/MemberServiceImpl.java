package hello.itemservice.service;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void update(Long memberId, MemberUpdateDto updateParam) {
        memberRepository.update(memberId, updateParam);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        return memberRepository.findAll(cond);
    }
}
