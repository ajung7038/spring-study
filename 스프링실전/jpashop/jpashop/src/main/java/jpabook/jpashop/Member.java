package jpabook.jpashop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Member
{
    @Id @GeneratedValue
    // 5분 27초
    private Long id;
}
