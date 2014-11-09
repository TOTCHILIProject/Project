package Tochtli.Tochtli.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.dao.ProductDAO;
import Tochtli.Tochtli.model.entity.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	public ProductServiceImpl(ProductDAO pd) {
		this.productDAO = pd;
	}

	public ProductServiceImpl() {

	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAllProducts() {
		return productDAO.findAllProducts();
	}

	@Override
	@Transactional
	public void persistProduct(Product product) {
		productDAO.persistEmployee(product);

	}

}
