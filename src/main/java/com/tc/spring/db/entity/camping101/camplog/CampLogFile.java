package com.tc.spring.db.entity.camping101.camplog;

import com.tc.spring.db.entity.camping101.attachfile.AttachFile;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class CampLogFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_log_file_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_file_id")
    private AttachFile attachFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_log_id")
    public CampLog campLog;

}
