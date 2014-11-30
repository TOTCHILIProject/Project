package Tochtli.Tochtli.model.services;

import java.util.List;

import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.pojo.OrderFilter;

public interface OrderService {

	public void placeOrder(Order order);
	
	public List<Order> getAllOrders();

	public List<Order> getAllOrdersByFilter(OrderFilter filter);
}
