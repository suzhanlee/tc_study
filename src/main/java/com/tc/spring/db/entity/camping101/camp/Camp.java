package com.tc.spring.db.entity.camping101.camp;

import static javax.persistence.EnumType.STRING;

import com.tc.spring.db.entity.camping101.base.BaseCreateDateTimeEntity;
import com.tc.spring.db.entity.camping101.attachfile.AttachFile;
import com.tc.spring.db.entity.camping101.camp.enums.AnimalCapabilityType;
import com.tc.spring.db.entity.camping101.camp.enums.ManageStatus;
import com.tc.spring.db.entity.camping101.camp.enums.ReservationType;
import com.tc.spring.db.entity.camping101.campauth.CampAuth;
import com.tc.spring.db.entity.camping101.member.Member;
import com.tc.spring.db.entity.camping101.site.Site;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Camp extends BaseCreateDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_id")
    private Long campId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String intro;

    @Enumerated(STRING)
    @Column(nullable = false)
    private ManageStatus manageStatus;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(STRING)
    @Column(nullable = false)
    private ReservationType reservationType;

    @Column(nullable = false)
    private String businessNo;

    @Column(nullable = false)
    private AnimalCapabilityType animalCapabilityType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "camp_details_id")
    private CampDetails campDetails; // -> 이것도 여기에 다 넣어도 되는지 애매하다

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_file_id")
    private AttachFile firstImage;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "camp_location_id")
    private CampLocation campLocation;

    @OneToMany(mappedBy = "camp", cascade = CascadeType.REMOVE) // -> 애매
    private List<CampOpenDay> campOpenDayList = new ArrayList<>();

    @OneToMany(mappedBy = "camp", cascade = CascadeType.REMOVE) // -> 이거 애매하다
    private List<CampOpenSeason> campOpenSeasons = new ArrayList<>();

    @OneToMany(mappedBy = "camp", cascade = CascadeType.REMOVE)
    private List<CampFacility> campFacilities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "camp", cascade = CascadeType.REMOVE)
    private List<Site> sites = new ArrayList<>();

    @OneToMany(mappedBy = "camp", cascade = CascadeType.REMOVE)
    private List<CampAuth> campAuthList = new ArrayList<>();


}
