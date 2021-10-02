package pl.beda.UserAuthenticationSystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.beda.UserAuthenticationSystem.entity.Item;

public interface ItemService {
	
	
	public void saveItem(Item item);
	
	public List<Item> getItemsWithQuantityOverTwenty();
	
	public List<Item> getItemsWithQuantityOver(int minQuantityThreshold);
	
	public List<Item> getItemsWithNameLike(String regex);
	
	public List<Item> findByQuantity(Integer quantity);
	
	public List<Item> findByQuantityBetween(Integer minQuantity, Integer maxQuantity);
	
	public List<Item> findByQuantityGreaterThanEqualOrderByQuantityDesc(Integer minQuantity);
	
	public Page<Item> findAll(Pageable pageable);

}
