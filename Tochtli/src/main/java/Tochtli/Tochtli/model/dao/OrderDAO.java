package Tochtli.Tochtli.model.dao;

import java.util.List;

import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.pojo.OrderFilter;

public interface OrderDAO {

	public void persistOrder(Order order);
	
	public List<Order> getAllOrders();

	public List<Order> getAllOrdersByFilter(OrderFilter filter);
	
}
