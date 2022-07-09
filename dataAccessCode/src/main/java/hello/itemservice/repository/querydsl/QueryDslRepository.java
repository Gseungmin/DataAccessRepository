package hello.itemservice.repository.querydsl;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.domain.Member;
import hello.itemservice.domain.QMember;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.repository.MemberSearchCond;
import hello.itemservice.repository.MemberUpdateDto;
import hello.itemservice.repository.jpa.JpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static hello.itemservice.domain.QMember.*;

@Slf4j
public class QueryDslRepository implements MemberRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public QueryDslRepository(EntityManager em, JPAQueryFactory jpaQueryFactory) {
        this.em = em;
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public void update(Long memberId, MemberUpdateDto updateParam) {
        Member member = queryFactory.selectFrom(QMember.member).where(QMember.member.id.eq(memberId)).fetchOne();
        member.setUsername(updateParam.getUsername());
        member.setAge(updateParam.getAge());
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = queryFactory.selectFrom(QMember.member).where(QMember.member.id.eq(id)).fetchOne();
        return Optional.ofNullable(member);
    }

    /**동적쿼리*/
    @Override
    public List<Member> findAll(MemberSearchCond condition) {
        return queryFactory.selectFrom(member)
                .where(
                        combineMethod(condition.getUsername(), condition.getMaxAge())
                ).fetch();
    }

    /** Where 다중 파라미터 사용
     * 조건: 이름이 이름 param을 포함하고 나이가 param보다 작거나 같은 모든 회원 조회 동적 쿼리
     * 조립이 가능하고 재사용성이 있다는 장점이 있다.
     * */
    private BooleanExpression nameContain(String nameCond) {
        return nameCond != null ? member.username.contains(nameCond) : null;
    }

    private BooleanExpression ageLoe(Integer ageCond) {
        return ageCond != null ? member.age.loe(ageCond) : null;
    }

    private Predicate combineMethod(String nameCond, Integer ageCond) {
        if (nameCond == null && ageCond == null) {
            return null;
        } else if(nameCond == null && ageCond != null) {
            return ageLoe(ageCond);
        } else if(nameCond != null && ageCond == null) {
            return nameContain(nameCond);
        } else {
            return nameContain(nameCond).and(ageLoe(ageCond));
        }
    }
}
