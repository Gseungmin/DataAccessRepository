package hello.itemservice.repository.jdbctemplate;

import hello.itemservice.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**jdbc 템플릿 구현*/
@Slf4j
public class JdbcTemplateRepository implements MemberRepository {

    private final NamedParameterJdbcTemplate template;
    private final SimpleJdbcInsert jdbcInsert;
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(member);
        Number key = jdbcInsert.executeAndReturnKey(param);
        member.setId(key.longValue());
        return member;
    }

    @Override
    public void update(Long memberId, MemberUpdateDto updateParam) {
        String sql = "update member " +
                "set username=:username, age=:age " +
                "where id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("username", updateParam.getUsername())
                .addValue("age", updateParam.getAge())
                .addValue("id", memberId);
        template.update(sql, param);
    }

    @Override
    public Optional<Member> findById(Long id) {
        String sql = "select id, username, age from member where id = :id";
        try {
            Map<String, Object> param = Map.of("id", id);
            Member member = template.queryForObject(sql, param, memberRowMapper());
            return Optional.of(member);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        Integer maxAge = cond.getMaxAge();
        String username = cond.getUsername();
        SqlParameterSource param = new BeanPropertySqlParameterSource(cond);
        String sql = "select id, username, age from member";
        //동적 쿼리
        if (StringUtils.hasText(username) || maxAge != null) {
            sql += " where";
        }
        boolean andFlag = false;
        if (StringUtils.hasText(username)) {
            sql += " username like concat('%',:username,'%')";
            andFlag = true;
        }
        if (maxAge != null) {
            if (andFlag) {
                sql += " and";
            }
            sql += " age <= :maxAge";
        }
        log.info("sql={}", sql);
        return template.query(sql, param, memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
        return BeanPropertyRowMapper.newInstance(Member.class);
    }

    @Override
    public void delete(String name) {
        String query = "delete from Member where username = ?";
        jdbcTemplate.update(query, name);
    }
}