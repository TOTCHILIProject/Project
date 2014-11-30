package Tochtli.Tochtli.model.dao;

import java.util.List;

import Tochtli.Tochtli.model.entity.Product;

public interface ProductDAO {

	public List<Product> findAllProducts();

	public void persistProduct(Product product);

	public Product findProductById(long id);

	public void updateProduct(Product product);

}
