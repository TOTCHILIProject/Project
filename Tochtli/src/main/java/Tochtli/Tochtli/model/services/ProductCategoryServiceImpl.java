package Tochtli.Tochtli.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.dao.CategoryDAO;
import Tochtli.Tochtli.model.dao.ProductDAO;
import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Product;

@Service("productService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	public ProductCategoryServiceImpl(ProductDAO pd) {
		this.productDAO = pd;
	}

	public ProductCategoryServiceImpl() {

	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAllProducts() {
		return productDAO.findAllProducts();
	}

	@Override
	@Transactional
	public void persistProduct(Product product) {
		productDAO.persistProduct(product);

	}

	@Override
	public List<Category> findAllCategories() {
		return categoryDAO.findAllCategories();
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryDAO.findById(id);
	}

}
