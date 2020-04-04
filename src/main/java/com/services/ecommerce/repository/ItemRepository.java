package com.services.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.services.ecommerce.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
//	@Query("Select quantity from Item where itemId = :id")
//	public Integer getQuantityByItemId(@Param("id") Long itemId); 
}
