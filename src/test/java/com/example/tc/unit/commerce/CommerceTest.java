package com.example.tc.unit.commerce;

import static com.example.tc.unit.enums.ErrorMessage.INVAILD_ITEM_SHOULD_BE_POSITIVE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.tc.unit.enums.ErrorMessage;
import com.example.tc.unit.item.Bag;
import com.example.tc.unit.item.Cup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommerceTest {

    @Test
    @DisplayName("아이템 1개를 추가하면 아이템 리스트에 담긴다.")
    void addItem() {
        Commerce commerce = new Commerce();
        commerce.add(new Bag(), 1);

        assertThat(commerce.getItemList()).hasSize(1);
        assertThat(commerce.getItemList().get(0).getPrice()).isEqualTo(3000);
    }

    @Test
    @DisplayName("아이템 여러개를 추가하면 아이템 리스트에 담긴다.")
    void add() {
        Commerce commerce = new Commerce();
        Bag bag = new Bag();
        Cup cup = new Cup();
        commerce.add(bag, 2);
        commerce.add(cup, 1);

        assertThat(commerce.getItemList()).hasSize(3);
        assertThat(commerce.getItemList().get(0).getPrice()).isEqualTo(3000);
        assertThat(commerce.getItemList().get(1).getName()).isEqualTo("가방");
        assertThat(commerce.getItemList().get(2).getName()).isEqualTo("컵");

    }

    @Test
    @DisplayName("아이템 주문시 0이하의 숫자를 넣으면 IllegalArgumentException이 발생한다")
    void addItemWithZero() {
        Commerce commerce = new Commerce();
        Bag bag = new Bag();

        assertThatThrownBy(() -> commerce.add(bag, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVAILD_ITEM_SHOULD_BE_POSITIVE_NUMBER.getDescription());


    }
}