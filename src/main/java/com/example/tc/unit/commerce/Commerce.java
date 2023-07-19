package com.example.tc.unit.commerce;

import static com.example.tc.unit.enums.ErrorMessage.INVAILD_ITEM_SHOULD_BE_POSITIVE_NUMBER;

import com.example.tc.unit.enums.ErrorMessage;
import com.example.tc.unit.item.Item;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Commerce {


    private final List<Item> itemList = new ArrayList<>();

    public void add(Item item, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(INVAILD_ITEM_SHOULD_BE_POSITIVE_NUMBER.getDescription());
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
}
