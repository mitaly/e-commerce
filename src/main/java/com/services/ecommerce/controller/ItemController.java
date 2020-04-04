package com.services.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.ecommerce.entity.Item;
import com.services.ecommerce.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	private ItemService service;
	public ItemController(ItemService itemService) {
		this.service = itemService;
	}
	@PostMapping
	public ResponseEntity<Long> create(@RequestBody @NonNull Item item){
		return new ResponseEntity<Long>(service.create(item), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getById(@PathVariable("id") @NonNull Long id){
		HttpStatus status = HttpStatus.OK;
		Item item = service.getById(id);
		if(item == null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Item>(item,status);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> update(@PathVariable("id") @NonNull Long id, @RequestBody @NonNull Item item){
		return new ResponseEntity<Item>(service.update(id, item), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") @NonNull Long id){
		service.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<List<Item>> getAll(){
		return new ResponseEntity<List<Item>>(service.getAll(), HttpStatus.OK);
	}
}
