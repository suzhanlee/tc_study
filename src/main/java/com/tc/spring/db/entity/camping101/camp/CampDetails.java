package com.tc.spring.db.entity.camping101.camp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    private String equipmentTools; // 캠핑장에서 제공해주는 무료 도구들

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id")
    private Camp camp; // 외래키가 camp에 있으면 정합성 문제도 발생 가능(null)
}
