package pl.beda.UserAuthenticationSystem.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import pl.beda.UserAuthenticationSystem.entity.Item;

public interface ItemPagingAndSortingRepository extends PagingAndSortingRepository<Item, Long> {

}
