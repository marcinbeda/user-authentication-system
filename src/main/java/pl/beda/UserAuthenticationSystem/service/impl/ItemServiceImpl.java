package pl.beda.UserAuthenticationSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.beda.UserAuthenticationSystem.entity.Item;
import pl.beda.UserAuthenticationSystem.repository.ItemPagingAndSortingRepository;
import pl.beda.UserAuthenticationSystem.repository.ItemRepository;
import pl.beda.UserAuthenticationSystem.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemPagingAndSortingRepository itemPagingAndSortingRepository;
	

	@Override
	public void saveItem(Item item) {
		itemRepository.save(item);
	}


	@Override
	public List<Item> getItemsWithQuantityOverTwenty() {
		return itemRepository.getItemsWithQuantityOverTwenty();
	}


	@Override
	public List<Item> getItemsWithQuantityOver(int minQuantityThreshold ) {
		return itemRepository.getItemsWithQuantityOver(minQuantityThreshold);
	}


	@Override
	public List<Item> getItemsWithNameLike(String regex) {
		return itemRepository.getItemsWithNameLike(regex);
	}


	@Override
	public List<Item> findByQuantity(Integer quantity) {
		return itemRepository.findByQuantity(quantity);
	}


	@Override
	public List<Item> findByQuantityBetween(Integer minQuantity, Integer maxQuantity) {
		return itemRepository.findByQuantityBetween(minQuantity, maxQuantity);
	}


	@Override
	public List<Item> findByQuantityGreaterThanEqualOrderByQuantityDesc(Integer minQuantity) {
		return itemRepository.findByQuantityGreaterThanEqualOrderByQuantityDesc(minQuantity);
	}


	@Override
	public Page<Item> findAll(Pageable pageable) {
		return itemPagingAndSortingRepository.findAll(pageable);
	}

}
