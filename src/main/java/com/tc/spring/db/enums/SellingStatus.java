package com.tc.spring.db.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SellingStatus {


    SELLING("판매중"),
    SOLD_OUT("매진"),
    STOP_SELLING("판매중지");


    private final String description;
}
