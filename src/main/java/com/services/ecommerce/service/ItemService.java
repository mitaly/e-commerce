package com.services.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.services.ecommerce.entity.Item;
import com.services.ecommerce.repository.ItemRepository;

@Service
public class ItemService {
	private ItemRepository repo;
	public ItemService(ItemRepository itemRepository) {
		this.repo = itemRepository;
	}
	
	public Long create(Item item) {
		Item savedItem = repo.save(item);
		return savedItem.getItemId();
	}
	
	public Item getById(Long itemId) {
		Optional<Item> optional = repo.findById(itemId);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	public Item update(Long itemId, Item item) {
		item.setItemId(itemId);
		return repo.save(item);
	}

	public void delete(Long itemId) {
		repo.deleteById(itemId);
	}
	
	public List<Item> getAll(){
		return repo.findAll();
	}
}
