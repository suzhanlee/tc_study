package com.tc.spring.db.entity.camping101.site;

import com.tc.spring.db.entity.camping101.base.BaseEntity;
import com.tc.spring.db.entity.camping101.camp.Camp;
import com.tc.spring.db.entity.camping101.camplog.CampLog;
import com.tc.spring.db.entity.camping101.reservation.Reservation;
import com.tc.spring.db.entity.camping101.site.enums.SiteStatus;
import com.tc.spring.db.entity.camping101.site.enums.SiteType;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Site extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_id")
    private Long siteId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String introduction;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SiteType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SiteStatus siteStatus;

    @Column(nullable = false)
    private LocalTime checkIn;

    @Column(nullable = false)
    private LocalTime checkOut;

    @Column(nullable = false)
    private int leastScheduling;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id")
    private Camp camp;

    @OneToMany(mappedBy = "site")
    private List<SiteCapability> siteCapabilities = new ArrayList<>(); // -> 이거 맞을까?

    @OneToMany(mappedBy = "site")
    private List<SiteFile> siteFiles = new ArrayList<>(); // rpImage, mapImage -> name으로 처리

    @OneToMany(mappedBy = "site")
    private List<SiteCapacity> siteCapacities = new ArrayList<>();

    @OneToMany(mappedBy = "site")
    private List<Reservation> reservationList = new ArrayList<>();

    @OneToMany(mappedBy = "site")
    private List<CampLog> campLogList = new ArrayList<>();

}
