package hello.itemservice.repository.myBatis;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
/**MyBatis 구현*/
public class MyBatisRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public Member save(Member item) {
        memberMapper.save(item);
        return item;
    }

    @Override
    public void update(Long itemId, MemberUpdateDto updateParam) {
        memberMapper.update(itemId, updateParam);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberMapper.findById(id);
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        return memberMapper.findAll(cond);
    }
}
