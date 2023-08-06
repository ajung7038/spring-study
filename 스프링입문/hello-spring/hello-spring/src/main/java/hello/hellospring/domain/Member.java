package hello.hellospring.domain;

import jakarta.persistence.*;

import java.security.Identity;

//JPA가 관리하는 엔티티
@Entity
public class Member {
    // 시스템이 정하는 임의의 값 (데이터 구분용)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
