package com.tc.spring.db.entity.camping101.member;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

//@RedisHash(value = "blackAccessToken")
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AccessTokenBlackList {

    @Id
    private Long memberId;

    private List<String> blackList;

}
