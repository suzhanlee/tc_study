package com.tc.spring.domain.item.controller;

import static com.tc.spring.db.enums.ItemType.BAG;
import static com.tc.spring.db.enums.SellingStatus.SELLING;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tc.spring.domain.item.model.rq.SaveItemRq;
import com.tc.spring.domain.item.service.FindItemService;
import com.tc.spring.domain.item.service.ItemService;
import com.tc.spring.domain.path.ApiPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private FindItemService findItemService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("새로운 아이템을 등록한다.")
    void saveItem() throws Exception {
        // given
        SaveItemRq rq = SaveItemRq.of("001", "샤넬백", BAG, 4_500_000, SELLING);

        // when // then
        mockMvc.perform(
            MockMvcRequestBuilders.post(ApiPath.ITEM_V1)
                .content(objectMapper.writeValueAsString(rq))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }




}