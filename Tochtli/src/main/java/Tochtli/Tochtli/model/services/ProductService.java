package Tochtli.Tochtli.model.services;

import java.util.List;

import Tochtli.Tochtli.model.entity.Product;

public interface ProductService {

	public List<Product> findAllProducts();

	public void persistProduct(Product product);
}
