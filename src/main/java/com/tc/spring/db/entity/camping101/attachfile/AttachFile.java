package com.tc.spring.db.entity.camping101.attachfile;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class AttachFile {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "attach_file_id")
    private Long id;

    @Column(nullable = false)
    private String fileUid;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Integer fileSize;
}
