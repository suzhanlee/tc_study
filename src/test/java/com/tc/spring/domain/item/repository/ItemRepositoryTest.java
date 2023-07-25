package com.tc.spring.domain.item.repository;

import static com.tc.spring.db.enums.SellingStatus.STOP_SELLING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.ItemType;
import com.tc.spring.db.enums.SellingStatus;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
@SpringBootTest
@ActiveProfiles("test")
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @AfterEach
    void tearDown() {
        itemRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("상품을 등록할 수 있다.")
    void saveItemList() {
        // given
        Item bag1 = Item.create("001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING);
        Item bag2 = Item.create("002", "루이비똥백", ItemType.BAG, 5_300_000, SellingStatus.SOLD_OUT);
        Item bag3 = Item.create("003", "에르메스백", ItemType.BAG, 9_900_000,
            STOP_SELLING);
        // when
        List<Item> list = itemRepository.saveAll(List.of(bag1, bag2, bag3));

        // then
        assertThat(list)
            .hasSize(3)
            .extracting("itemNumber", "name", "itemType", "price", "sellingStatus")
            .containsExactlyInAnyOrder(
                tuple("001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING),
                tuple("002", "루이비똥백", ItemType.BAG, 5_300_000, SellingStatus.SOLD_OUT),
                tuple("003", "에르메스백", ItemType.BAG, 9_900_000, STOP_SELLING));
    }

    @Test
    @DisplayName("판매 상태로 아이템을 찾아볼 수 있다.")
    void findBySellingStatusIn() {
        // given
        Item bag1 = Item.create("001", "샤넬백", ItemType.BAG, 4_500_000, SellingStatus.SELLING);
        Item bag2 = Item.create("002", "루이비똥백", ItemType.BAG, 5_300_000, SellingStatus.SOLD_OUT);
        Item bag3 = Item.create("003", "에르메스백", ItemType.BAG, 9_900_000,
            STOP_SELLING);
        Item bag4 = Item.create("004", "구찌백", ItemType.BAG, 9_900_000, STOP_SELLING);
        itemRepository.saveAll(List.of(bag1, bag2, bag3, bag4));

        // when
        List<Item> itemList = itemRepository.findBySellingStatusIn(List.of(STOP_SELLING));

        // then
        assertThat(itemList)
            .hasSize(2)
            .extracting("itemNumber", "name", "itemType", "price", "sellingStatus")
            .containsExactlyInAnyOrder(
                tuple("003", "에르메스백", ItemType.BAG, 9_900_000, STOP_SELLING),
            tuple("004", "구찌백", ItemType.BAG, 9_900_000, STOP_SELLING));
    }
}