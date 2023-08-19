package com.tc.spring.db.entity.camping101.camplog;

import com.tc.spring.db.entity.camping101.base.BaseEntity;
import com.tc.spring.db.entity.camping101.bookmark.BookMark;
import com.tc.spring.db.entity.camping101.comment.Comment;
import com.tc.spring.db.entity.camping101.member.Member;
import com.tc.spring.db.entity.camping101.regtag.RecTag;
import com.tc.spring.db.entity.camping101.reservation.Reservation;
import com.tc.spring.db.entity.camping101.site.Site;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CampLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_log_id")
    private Long campLogId;

    @Column(nullable = false)
    private LocalDateTime visitedAt;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Max(2000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    private Site site;

    @OneToMany(mappedBy = "campLog")
    private List<RecTag> recTags = new ArrayList<>();

    @OneToMany(mappedBy = "campLog", cascade = CascadeType.REMOVE)
    private List<CampLogFile> campLogFiles = new ArrayList<>();

    @OneToMany(mappedBy = "campLog", cascade = CascadeType.REMOVE)
    private List<BookMark> bookMarks = new ArrayList<>();

    @OneToMany(mappedBy = "campLog", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

}
