package hello.itemservice.repository.springdatajpa;

import hello.itemservice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<Member, Long> {

    //이름 조건만 검색
    List<Member> findByUsernameLike(String username);

    //가격 조건만 검색
    List<Member> findByAgeLessThanEqual(Integer age);

    /**아래 두개가 같은 메서드
     * 이름 및 가격 조건으로 검색
     * 동적쿼리를 만들면 좋겠지만 동적쿼리가 약하므로 이 부분을 QueryDsl을 사용해서 해결한다.
     * */
    //쿼리 메서드
    List<Member> findByUsernameLikeAndAgeLessThanEqual(String username, Integer age);

    //쿼리 직접 실행
    @Query("select m from Member m where m.username like :username and m.age <= :age")
    List<Member> findMembers(@Param("username") String username, @Param("age") Integer age);
}
