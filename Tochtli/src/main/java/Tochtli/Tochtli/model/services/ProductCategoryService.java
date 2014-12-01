package Tochtli.Tochtli.model.services;

import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeriesCollection;

import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.entity.Product;

public interface ProductCategoryService {

	public List<Product> findAllProducts();

	public List<Category> findAllCategories();
	
	public void persistProduct(Product product);
	
	public Category getCategoryById(Long id);
	
	public String addToCart(Order order,int quantity,long idProduct);
	
	public void removeFromCart(Order order,long idProduct);
	
	public Product getProductById(Long id);
	
	public void deleteProduct(Long id);
	
	public void deleteCategory(Long id);
	
	public void persistCategory(Category category);
	
	public DefaultPieDataset getStockPieDataSet();
	
	public DefaultCategoryDataset getOrdersBarDataSet();
	
	public TimeSeriesCollection getOrdersMonthSeries();
}
