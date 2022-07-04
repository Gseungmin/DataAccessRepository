package hello.itemservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Member Form*/
@Getter @Setter
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
