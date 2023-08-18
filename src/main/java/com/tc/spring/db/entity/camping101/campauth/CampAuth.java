package com.tc.spring.db.entity.camping101.campauth;

import com.tc.spring.db.entity.camping101.base.BaseCreateDateTimeEntity;
import com.tc.spring.db.entity.camping101.camp.Camp;
import com.tc.spring.db.entity.camping101.campauth.enums.CampAuthStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CampAuth extends BaseCreateDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_auth_id")
    private Long campAuthId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CampAuthStatus campAuthStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id")
    private Camp camp;

}
