package Tochtli.Tochtli.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.entity.Order;

@Repository("OrderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public OrderDAOImpl() {
	}

	public OrderDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void persistOrder(Order order) {
		order.setDate(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

	@Override
	@Transactional
	public List<Order> getAllOrders() {
		Query query = sessionFactory.getCurrentSession().createQuery("from " + Order.class.getName());

		return (List<Order>) query.list();

	}

}
