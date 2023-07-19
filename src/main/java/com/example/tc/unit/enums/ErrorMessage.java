package com.example.tc.unit.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessage {

    INVAILD_ITEM_SHOULD_BE_POSITIVE_NUMBER("아이템은 1개 이상 주문 가능 합니다."),

    INVAILD_ORDER_TIME("현재는 주문 시간이 아닙니다.");


    private final String description;


}
