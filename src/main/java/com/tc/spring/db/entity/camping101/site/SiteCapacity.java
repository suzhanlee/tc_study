package com.tc.spring.db.entity.camping101.site;

import com.tc.spring.db.entity.camping101.site.enums.SiteCapacityType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class SiteCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_capacity_id")
    private Long id;

    private SiteCapacityType siteCapacityType;

    private Integer siteCapacityCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    private Site site;

}
