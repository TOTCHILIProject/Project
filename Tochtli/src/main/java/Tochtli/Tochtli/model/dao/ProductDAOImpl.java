package Tochtli.Tochtli.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.entity.Product;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl() {
	}

	public ProductDAOImpl(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public List<Product> findAllProducts() {

		Query query = sessionFactory.getCurrentSession().createQuery("from " + Product.class.getName());

		return (List<Product>) query.list();
	}

	@Override
	public void persistProduct(Product product) {
		sessionFactory.getCurrentSession().persist(product);
	}

	@Override
	@Transactional
	public Product findProductById(long id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);

	}

	@Override
	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
	}

}
