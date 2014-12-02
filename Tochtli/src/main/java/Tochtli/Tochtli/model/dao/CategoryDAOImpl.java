package Tochtli.Tochtli.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.entity.Category;

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
		//for some reason cannot pass the products to the form 
		if (category.getId() != null) {
			// edit category
			Category c = findById(category.getId());
			if (c != null) {
				c.setDescription(category.getDescription());
				c.setName(category.getName());
				c.setPhoto_path(category.getPhoto_path());
				category = c;
			}
		}

		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	@Override
	@Transactional
	public Category findById(Long id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public void updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	@Override
	public void deleteCategory(Category category) {
		sessionFactory.getCurrentSession().delete(category);
	}

}
