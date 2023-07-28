package com.tc.spring.domain.item.model.rs;

import com.tc.spring.domain.item.dto.FindItemDto;
import java.util.List;
import lombok.Getter;

@Getter
public class FindAllItemListRs {

    private List<FindItemDto> list;

    public static FindAllItemListRs of(List<FindItemDto> list) {
        FindAllItemListRs rs = new FindAllItemListRs();
        rs.list = list;
        return rs;
    }
}
