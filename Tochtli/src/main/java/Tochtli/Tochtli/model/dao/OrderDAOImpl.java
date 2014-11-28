package Tochtli.Tochtli.model.dao;

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
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

}
