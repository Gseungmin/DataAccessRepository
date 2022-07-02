package hello.itemservice.repository;

import lombok.Data;

@Data
public class MemberUpdateDto {
    private String username;
    private Integer age;

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
