package com.tc.spring.domain.item.repository;

import com.tc.spring.db.entity.Item;
import com.tc.spring.db.enums.SellingStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findBySellingStatusIn(List<SellingStatus> sellingStatusList);

}
