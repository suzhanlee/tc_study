package com.example.tc.unit.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BagTest {
    
    @Test
    @DisplayName("가방 유닛 테스트")
    void bagUnitTest(){

        Bag bag = new Bag();
        assertThat(bag.getPrice()).isEqualTo(3000);
        assertThat(bag.getName()).isEqualTo("가방");

    }

}