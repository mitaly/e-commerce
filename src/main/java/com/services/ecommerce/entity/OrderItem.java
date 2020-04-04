package com.services.ecommerce.entity;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "e_com_order_item")
public class OrderItem {

	private OrderItemId orderItemId;
	private Integer quantity;

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	@JsonIgnoreProperties(value = {"order"})
	public OrderItemId getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(OrderItemId orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderItem [orderItemId=");
		builder.append(orderItemId.getItem().getItemId());
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
}
