package Tochtli.Tochtli.model.services;

import java.util.List;

import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Product;

public interface ProductCategoryService {

	public List<Product> findAllProducts();

	public List<Category> findAllCategories();
	
	public void persistProduct(Product product);
}
