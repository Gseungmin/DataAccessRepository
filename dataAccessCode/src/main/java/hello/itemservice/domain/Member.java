package hello.itemservice.domain;

import lombok.Data;

/**
 * Member Form*/
@Data
public class Member {

    private Long id;

    private String username;
    private Integer age;

    public Member() {
    }

    public Member(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
