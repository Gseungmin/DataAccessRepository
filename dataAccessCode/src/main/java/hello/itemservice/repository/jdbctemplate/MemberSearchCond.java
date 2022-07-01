package hello.itemservice.repository.jdbctemplate;

import lombok.Data;

@Data
public class MemberSearchCond {

    private String username;
    private Integer maxAge;

    public MemberSearchCond() {
    }

    public MemberSearchCond(String username, Integer maxAge) {
        this.username = username;
        this.maxAge = maxAge;
    }
}
