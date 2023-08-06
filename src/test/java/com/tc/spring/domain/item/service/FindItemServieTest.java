package com.tc.spring.domain.item.service;

import static com.tc.spring.db.enums.SellingStatus.SELLING;
import static com.tc.spring.db.enums.SellingStatus.SOLD_OUT;
import static com.tc.spring.db.enums.SellingStatus.STOP_SELLING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import com.tc.spring.domain.item.repository.ItemRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class FindItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FindItemService findItemService;

    @AfterEach
    void tearDown() {
        itemRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("판매 상태가 판매중, 매진인 경우면 조회 할 수 있다.")
    void findAvailableItems() {
        // given
        Item bag1 = Item.create("001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING);
        Item bag2 = Item.create("002", "루이비똥백", ItemType.BAG, 5_300_000, SellingStatus.SOLD_OUT);
        Item bag3 = Item.create("003", "에르메스백", ItemType.BAG, 9_900_000,
            STOP_SELLING);
        Item bag4 = Item.create("004", "구찌백", ItemType.BAG, 9_900_000, STOP_SELLING);
        itemRepository.saveAll(List.of(bag1, bag2, bag3, bag4));
        // when
        List<Item> list = findItemService.findAvailableItems();

        // then
        assertThat(list)
            .hasSize(2)
            .extracting("itemNumber", "name", "itemType", "price", "sellingStatus")
            .containsExactlyInAnyOrder(
                tuple("001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING),
                tuple("002", "루이비똥백", ItemType.BAG, 5_300_000, SellingStatus.SOLD_OUT));

    }

    @Test
    @DisplayName("모든 상품을 찾아올 수 있다.")
    void findAllItemsTest() {
        // given
        Item bag1 = Item.create("001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING);
        Item bag2 = Item.create("002", "루이비똥백", ItemType.BAG, 5_300_000, SellingStatus.SOLD_OUT);
        Item bag3 = Item.create("003", "에르메스백", ItemType.BAG, 9_900_000,
            STOP_SELLING);
        Item bag4 = Item.create("004", "구찌백", ItemType.BAG, 9_900_000, STOP_SELLING);

        itemRepository.saveAll(List.of(bag1, bag2, bag3, bag4));


        // when
        List<Item> list = findItemService.findAllItems();

        // then
        assertThat(list)
            .hasSize(4)
            .extracting("itemNumber", "name", "itemType", "price", "sellingStatus")
            .containsExactlyInAnyOrder(
                tuple("001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING),
                tuple("002", "루이비똥백", ItemType.BAG, 5_300_000, SellingStatus.SOLD_OUT),
                tuple("003", "에르메스백", ItemType.BAG, 9_900_000, SellingStatus.STOP_SELLING),
                tuple("004", "구찌백", ItemType.BAG, 9_900_000, SellingStatus.STOP_SELLING));
    }


}