package pl.beda.UserAuthenticationSystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.beda.UserAuthenticationSystem.entity.Item;

public interface ItemService {

    void saveItem(Item item);

    List<Item> getItemsWithQuantityOverTwenty();

    List<Item> getItemsWithQuantityOver(int minQuantityThreshold);

    List<Item> getItemsWithNameLike(String regex);

    List<Item> findByQuantity(Integer quantity);

    List<Item> findByQuantityBetween(Integer minQuantity, Integer maxQuantity);

    List<Item> findByQuantityGreaterThanEqualOrderByQuantityDesc(Integer minQuantity);

    Page<Item> findAll(Pageable pageable);
}
