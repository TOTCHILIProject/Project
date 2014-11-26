package Tochtli.Tochtli.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Product;

@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl() {
	}

	public CategoryDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public List<Category> findAllCategories() {
		Query query = sessionFactory.getCurrentSession().createQuery("from " + Category.class.getName());

		return (List<Category>) query.list();
	}

	@Override
	public void persistCategory(Category category) {
		sessionFactory.getCurrentSession().persist(category);

	}

	@Override
	@Transactional
	public Category findById(Long id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

}
