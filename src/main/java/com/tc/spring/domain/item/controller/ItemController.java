package com.tc.spring.domain.item.controller;

import static com.tc.spring.domain.path.ApiPath.ITEM_V1;
import static com.tc.spring.domain.path.ApiPath.ITEM_V1_AVAILABLE;

import com.tc.spring.domain.global.ApiResponse;
import com.tc.spring.domain.item.model.rq.SaveItemRq;
import com.tc.spring.domain.item.model.rs.FindAllItemListRs;
import com.tc.spring.domain.item.model.rs.FindAvailableItemListRs;
import com.tc.spring.domain.item.service.FindItemService;
import com.tc.spring.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final FindItemService findItemService;

    @PostMapping(ITEM_V1)
    public void saveItem(@RequestBody @Validated SaveItemRq rq) {
        itemService.saveItem(rq);
    }
    @GetMapping(ITEM_V1)
    public ApiResponse<FindAllItemListRs> findAllItemList() {
        return ApiResponse.ok(findItemService.findAllItemList());
    }

    @GetMapping(ITEM_V1_AVAILABLE)
    public FindAvailableItemListRs findAvailableItemList() {
        return findItemService.findAvailableItemList();

    }



}
