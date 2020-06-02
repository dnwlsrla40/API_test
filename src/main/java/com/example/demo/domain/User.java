package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder    // builder 사용 가능
@Entity // jpa entity임을 알림
@Getter // user 필드 값의 getter를 자동으로 생성
@NoArgsConstructor  // 인자 없는 생성자를 자동으로 생성
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성
@Table(name="user") // user 테이블과 매핑
public class User {
    @Id //primary key 임을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성전략을 DB에 위임 = mysql로 치면 pk를 auto_increment로 설정
    private long msrl;

    @Column(nullable = false, unique = true, length =30)
    private String uid;

    @Column(nullable = false, length = 100)
    private String name;

}
