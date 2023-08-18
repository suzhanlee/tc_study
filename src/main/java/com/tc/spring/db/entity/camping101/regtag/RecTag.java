package com.tc.spring.db.entity.camping101.regtag;

import com.tc.spring.db.entity.camping101.base.BaseEntity;
import com.tc.spring.db.entity.camping101.camplog.CampLog;
import com.tc.spring.db.entity.camping101.regtag.enums.UseType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class RecTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_tag_id")
    private Long recTagId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private UseType useType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_log_id")
    private CampLog campLog;
}
