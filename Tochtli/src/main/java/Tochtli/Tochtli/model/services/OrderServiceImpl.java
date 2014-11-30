package Tochtli.Tochtli.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tochtli.Tochtli.model.dao.OrderDAO;
import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.pojo.OrderFilter;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	public OrderServiceImpl(OrderDAO od) {
		this.orderDAO = od;
	}

	public OrderServiceImpl() {

	}

	@Override
	public void placeOrder(Order order) {
		orderDAO.persistOrder(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	public List<Order> getAllOrdersByFilter(OrderFilter filter) {
		return orderDAO.getAllOrdersByFilter(filter);
	}
}
