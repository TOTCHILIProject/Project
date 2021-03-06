package Tochtli.Tochtli.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.pojo.OrderFilter;

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

	@Override
	@Transactional
	public List<Order> getAllOrdersByFilter(OrderFilter filter) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);
		if (filter.getStartDate() != null) {
			criteria.add(Restrictions.ge("date", filter.getStartDate()));
		}
		if (filter.getEndDate() != null) {
			criteria.add(Restrictions.le("date", filter.getEndDate()));
		}
		// only distinct orders
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return (List<Order>) criteria.list();
	}

	@Override
	@Transactional
	public List<Object[]> getInfosByMonth() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("total"));
		projectionList.add(Projections.rowCount());

		projectionList
				.add(Projections.sqlGroupProjection("month(date) as month, year(date) as year",
						"month(date), year(date)", new String[] { "month", "year" },
						new Type[] { StandardBasicTypes.INTEGER }));
		projectionList
		.add(Projections.sqlGroupProjection("year(date) as year",
				"year(date)", new String[] { "year" },
				new Type[] { StandardBasicTypes.INTEGER }));

		criteria.setProjection(projectionList);
		return criteria.list();
	}

	@Override
	@Transactional
	public List<Object[]> getInfosByYear() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("total"));
		projectionList.add(Projections.rowCount());

		projectionList
				.add(Projections.sqlGroupProjection("year(date) as year",
						"year(date)", new String[] { "year" },
						new Type[] { StandardBasicTypes.INTEGER }));

		criteria.setProjection(projectionList);
		return criteria.list();
	}
}
