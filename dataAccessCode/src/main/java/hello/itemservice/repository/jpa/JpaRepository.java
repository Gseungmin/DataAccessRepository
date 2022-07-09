package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Member;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**JPA 구현*/
@Slf4j
public class JpaRepository implements MemberRepository {

    private final EntityManager em;

    public JpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public void update(Long memberId, MemberUpdateDto updateParam) {
        Member member = em.find(Member.class, memberId);
        member.setAge(updateParam.getAge());
        member.setUsername(updateParam.getUsername());
        //트랜잭션이 커밋되는 시점에 스냅샷과 비교하여 Update쿼리가 나간다.
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    //동적쿼리 여전히 빡세다.
    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        String jpql = "select m from Member m";
        Integer maxAge = cond.getMaxAge();
        String username = cond.getUsername();
        if (StringUtils.hasText(username) || maxAge != null) {
            jpql += " where";
        }
        boolean andFlag = false;
        List<Object> param = new ArrayList<>();
        if (StringUtils.hasText(username)) {
            jpql += " m.username like concat('%',:username,'%')";
            param.add(username);
            andFlag = true;
        }
        if (maxAge != null) {
            if (andFlag) {
                jpql += " and";
            }
            jpql += " m.age <= :maxAge";
            param.add(maxAge);
        }
        log.info("jpql={}", jpql);
        TypedQuery<Member> query = em.createQuery(jpql, Member.class);
        if (StringUtils.hasText(username)) {
            query.setParameter("username", username);
        }
        if (maxAge != null) {
            query.setParameter("maxAge", maxAge);
        }
        return query.getResultList();
    }
}
