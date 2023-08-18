package com.tc.spring.db.entity.camping101.member;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import com.tc.spring.db.entity.camping101.base.BaseCreateDateTimeEntity;
import com.tc.spring.db.entity.camping101.member.enums.SignUpType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class MemberLogInLog extends BaseCreateDateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(STRING)
    private SignUpType signUpType;

}
