package com.tc.spring.db.entity.camping101.camp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CampDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_details_id")
    private Long id;

    private String homepage; // 홈페이지는 있을 수도 있고, 없을 수도 있어서

    private String equipmentTools; // 제공되는 도구들

}
