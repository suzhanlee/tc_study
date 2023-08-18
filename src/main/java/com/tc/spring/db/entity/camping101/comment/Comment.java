package com.tc.spring.db.entity.camping101.comment;

import com.tc.spring.db.entity.camping101.base.BaseEntity;
import com.tc.spring.db.entity.camping101.camplog.CampLog;
import com.tc.spring.db.entity.camping101.member.Member;
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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    // member를 삭제하면 comment도 삭제해야 하나?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_log_id")
    private CampLog campLog;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.REMOVE)
    private List<ReComment> reComments = new ArrayList<>();

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


}