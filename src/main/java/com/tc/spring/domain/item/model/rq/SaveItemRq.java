package com.tc.spring.domain.item.model.rq;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SaveItemRq {

    @NotBlank
    private String itemNumber;

    @NotBlank
    private String name;

    @NotNull(message = "itemType은 필수값입니다.")
    private ItemType itemType;

    @NotNull
    private Integer price;

    @NotNull
    private SellingStatus sellingStatus;

    public Item toEntity() {
        return Item.create(itemNumber, name, itemType, price, sellingStatus);
    }

    public static SaveItemRq of(String itemNumber, String name, ItemType itemType, Integer price,
        SellingStatus sellingStatus) {
        SaveItemRq rq = new SaveItemRq();
        rq.itemNumber = itemNumber;
        rq.name = name;
        rq.itemType = itemType;
        rq.price = price;
        rq.sellingStatus = sellingStatus;
        return rq;
    }
}
