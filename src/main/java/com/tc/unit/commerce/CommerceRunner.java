package com.tc.unit.commerce;

import com.tc.unit.item.Bag;
import com.tc.unit.item.Cup;

public class CommerceRunner {

    public static void main(String[] args) {
        Commerce commerce = new Commerce();

        commerce.add(new Bag(), 2);
        System.out.println(">> 가방 추가");

        commerce.add(new Cup(), 2);
        System.out.println(">> 컵 추가");

        int totalPrice = commerce.calculateTotalPrice();
        System.out.println(">> 총 주문 가격 : " + totalPrice);
    }
}
