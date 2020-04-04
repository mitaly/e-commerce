package com.services.ecommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.services.ecommerce.constants.ECommerceConstants;
import com.services.ecommerce.entity.Item;
import com.services.ecommerce.entity.Order;
import com.services.ecommerce.entity.OrderItem;
import com.services.ecommerce.entity.OrderItemId;
import com.services.ecommerce.entity.User;
import com.services.ecommerce.exception.ECommerceException;
import com.services.ecommerce.repository.ItemRepository;
import com.services.ecommerce.repository.OrderRepository;
import com.services.ecommerce.repository.UserRepository;

@Service
public class OrderService {
	private OrderRepository repo;
	private ItemRepository itemRepo;
	private UserRepository userRepo;
	
	public OrderService(OrderRepository orderRepository, ItemRepository itemRepo, UserRepository userRepo) {
		this.repo = orderRepository;
		this.itemRepo = itemRepo;
		this.userRepo = userRepo;
	}
	
	public List<Order> getByEmailId(String emailId){
		return repo.getByEmailId(emailId);
	}
	
	public Order orderItems(List<Item> items, String email) throws ECommerceException{
		Optional<User> user = userRepo.findById(email);
		Date date = new Date();
		if(!user.isPresent()) {
			throw new ECommerceException(HttpStatus.BAD_REQUEST.value(), ECommerceConstants.USER_NOT_PRESENT, new String[] {email});
		}
		Order order = new Order(date, user.get());
		Set<OrderItem> itemsPresent = order.getOrderItem();
		
		for(Item item:items) {
			if(Objects.isNull(item.getItemId())) {
				throw new ECommerceException(HttpStatus.BAD_REQUEST.value(), ECommerceConstants.ITEM_ID_NOT_PRESENT);
			}
			
			Item itemInDb = itemRepo.findById(item.getItemId()).get();
			
			if(itemInDb.getQuantity() < item.getQuantity()) {
				throw new ECommerceException(HttpStatus.BAD_REQUEST.value(), ECommerceConstants.NOT_ENOUGH_QUANTITY,
						new String[] {item.getQuantity().toString(), item.getItemId().toString()});
			}
			
			
			itemInDb.setQuantity(itemInDb.getQuantity() - item.getQuantity());
			
			OrderItem orderItem = new OrderItem();
			orderItem.setQuantity(item.getQuantity());
			
			OrderItemId orderItemId = new OrderItemId();
			orderItemId.setItem(itemInDb);
			orderItemId.setOrder(order);
			
			orderItem.setOrderItemId(orderItemId);
			itemsPresent.add(orderItem);
			
			item.setItemName(itemInDb.getItemName());
			item.setPrice(itemInDb.getPrice());

			itemRepo.save(itemInDb);
			
		}
		repo.save(order);
		return order;
	}
}
