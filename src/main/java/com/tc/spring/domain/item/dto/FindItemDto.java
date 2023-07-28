package com.tc.spring.domain.item.dto;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FindItemDto {

    private String itemNumber;

    private String name;

    private ItemType itemType;

    private Integer price;

    private SellingStatus sellingStatus;

    public static FindItemDto of(Item item) {
        FindItemDto dto = new FindItemDto();
        dto.itemNumber = item.getItemNumber();
        dto.name = item.getName();
        dto.itemType = item.getItemType();
        dto.price = item.getPrice();
        dto.sellingStatus = item.getSellingStatus();
        return dto;
    }
}
