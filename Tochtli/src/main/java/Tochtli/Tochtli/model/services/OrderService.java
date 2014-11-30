package Tochtli.Tochtli.model.services;

import java.util.List;

import Tochtli.Tochtli.model.entity.Order;

public interface OrderService {

	public void placeOrder(Order order);
	
	public List<Order> getAllOrders();
}
