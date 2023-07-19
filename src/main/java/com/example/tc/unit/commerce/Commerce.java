package com.example.tc.unit.commerce;

import static com.example.tc.unit.enums.ErrorMessage.INVAILD_ITEM_SHOULD_BE_POSITIVE_NUMBER;
import static com.example.tc.unit.enums.ErrorMessage.INVAILD_ORDER_TIME;

import com.example.tc.unit.enums.ErrorMessage;
import com.example.tc.unit.item.Item;
import com.example.tc.unit.order.Order;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Commerce {

    private static final LocalTime ORDER_START_TIME = LocalTime.of(6, 0);
    private static final LocalTime ORDER_END_TIME = LocalTime.of(23, 0);

    private final List<Item> itemList = new ArrayList<>();

    public void add(Item item, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(
                INVAILD_ITEM_SHOULD_BE_POSITIVE_NUMBER.getDescription());
        }

        for (int i = 0; i < count; i++) {
            itemList.add(item);
        }
    }


    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Item item : itemList) {
            totalPrice += item.getPrice();
        }

        return totalPrice;

    }

    public void clear() {
        itemList.clear();
    }

    public void clear(Item item) {
        itemList.removeIf(it -> it.equals(item));

    }


    public Order createOrder(LocalDateTime nowDateTime) {
        LocalTime now = nowDateTime.toLocalTime();
        if (now.isAfter(ORDER_START_TIME) && now.isBefore(ORDER_END_TIME)) {
            return new Order(nowDateTime, itemList);
        }

        throw new IllegalArgumentException(INVAILD_ORDER_TIME.getDescription());
    }
















}
