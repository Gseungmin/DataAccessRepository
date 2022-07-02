package hello.itemservice.repository;

import lombok.Data;

/**
 * 검색 조건을 위한 Form*/
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
