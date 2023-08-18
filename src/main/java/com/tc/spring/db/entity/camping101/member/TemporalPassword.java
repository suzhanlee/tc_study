package com.tc.spring.db.entity.camping101.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//@RedisHash(value = "temporalPassword", timeToLive = 60L * 5) // 5분
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemporalPassword {

    @Id
    private String temporalPassword;
    private Long memberId;

}
