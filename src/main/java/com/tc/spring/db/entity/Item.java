package com.tc.spring.db.entity;

import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemNumber;

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private Integer price;

    private SellingStatus sellingStatus;

    public static Item create(String itemNumber, String name, ItemType itemType, Integer price, SellingStatus sellingStatus) {
        Item item = new Item();
        item.itemNumber = itemNumber;
        item.name = name;
        item.itemType = itemType;
        item.price = price;
        item.sellingStatus = sellingStatus;
        return item;
    }
}
