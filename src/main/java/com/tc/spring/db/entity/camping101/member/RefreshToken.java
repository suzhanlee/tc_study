package com.tc.spring.db.entity.camping101.member;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

//@RedisHash(value = "refreshToken")
@AllArgsConstructor
@Builder
@Getter
public class RefreshToken {

    @Id
    private String refreshToken;
    private String googleRefreshToken;
    private Long memberId;
    private LocalDateTime expiredAt;

}
