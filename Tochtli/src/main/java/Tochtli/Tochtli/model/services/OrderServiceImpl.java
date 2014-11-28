package Tochtli.Tochtli.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tochtli.Tochtli.model.dao.OrderDAO;
import Tochtli.Tochtli.model.entity.Order;

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
}
