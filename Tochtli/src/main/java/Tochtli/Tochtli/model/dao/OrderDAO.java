package Tochtli.Tochtli.model.dao;

import java.util.List;

import Tochtli.Tochtli.model.entity.Order;

public interface OrderDAO {

	public void persistOrder(Order order);
	
	public List<Order> getAllOrders();
	
}
