package com.example.tc.unit.order;

import com.example.tc.unit.item.Item;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Order {

    private final LocalDateTime createdDateTime;
    private final List<Item> itemList;





}
