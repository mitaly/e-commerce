package com.services.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.services.ecommerce.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	@Query("Select e from Order e where e.orderedBy.emailId = :email")
	public List<Order> getByEmailId(@Param("email") String email);
}
