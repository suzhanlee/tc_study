package com.tc.spring.domain.item.service;

import static com.tc.spring.db.enums.SellingStatus.*;
import static com.tc.spring.db.enums.SellingStatus.SELLING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import com.tc.spring.domain.item.repository.ItemRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ItemServiceTest {

    @Autowired
    private FindItemService findItemService;

    @Autowired
    private ItemService itemService;

    @Test
    @DisplayName("가방과 컵을 저장할 수 있다.")
    void saveItemTest(){
        // given
        Item bag = Item.create("BAG-001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING);
        Item cup = Item.create("CUP-001", "텀블러", ItemType.CUP, 21_000, SellingStatus.SELLING);

        // when
        itemService.saveItem(bag);
        itemService.saveItem(cup);

        // then
        findItemService.findAllItems();

    }



}