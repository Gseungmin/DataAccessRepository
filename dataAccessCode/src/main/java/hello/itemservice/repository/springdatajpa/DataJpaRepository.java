package hello.itemservice.repository.springdatajpa;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DataJpaRepository implements MemberRepository {

    private final SpringDataJpaRepository springDataJpaRepository;

    @Override
    public Member save(Member member) {
        return springDataJpaRepository.save(member);
    }

    @Override
    public void update(Long itemId, MemberUpdateDto updateParam) {
        Member member = springDataJpaRepository.findById(itemId).get();
        member.setAge(updateParam.getAge());
        member.setUsername(updateParam.getUsername());
    }

    @Override
    public Optional<Member> findById(Long id) {
        return springDataJpaRepository.findById(id);
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        String username = cond.getUsername();
        Integer maxAge = cond.getMaxAge();
        if (StringUtils.hasText(username) && maxAge != null) {
            return springDataJpaRepository.findMembers("%" + username + "%", maxAge);
        } else if (StringUtils.hasText(username)) {
            return springDataJpaRepository.findByUsernameLike("%" + username + "%");
        } else if (maxAge != null) {
            return springDataJpaRepository.findByAgeLessThanEqual(maxAge);
        } else {
            return springDataJpaRepository.findAll();
        }
    }
}
