package Tochtli.Tochtli.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tochtli.Tochtli.model.dao.CategoryDAO;
import Tochtli.Tochtli.model.dao.ProductDAO;
import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.entity.OrderedProduct;
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

	@Override
	public String addToCart(Order order, int quantity, long idProduct) {
		List<OrderedProduct> alreadyOrdered = order.getOrderedProducts();

		for (OrderedProduct oP : alreadyOrdered) {
			if (oP.getProduct().getId() == idProduct) {
				oP.addQuantity(quantity);
				order.addToTotal(quantity, oP.getProduct().getPrice());
				return "Product succesfully added to cart";
			}

		}
		// if the product wasn't in the cart
		Product product = productDAO.findProductById(idProduct);
		if (product == null) {
			return "An error has occured <br/> Invalid product ID";
		}
		OrderedProduct oP = new OrderedProduct(product, quantity);
		order.addToTotal(quantity, product.getPrice());
		order.addOrderedProduct(oP);
		return "Product succesfully added to cart";
	}

	@Override
	public void removeFromCart(Order order, long idProduct) {
		List<OrderedProduct> alreadyOrdered = order.getOrderedProducts();

		for (OrderedProduct oP : alreadyOrdered) {
			if (oP.getProduct().getId() == idProduct) {
				int q = oP.getQuantity();
				double p = oP.getProduct().getPrice();
				order.getOrderedProducts().remove(oP);
				order.addToTotal(q, (-1) * p);
				return;
			}

		}
	}

	@Override
	@Transactional
	public Product getProductById(Long id) {
		return productDAO.findProductById(id);
	}

	@Override
	@Transactional
	public void deleteProduct(Long id) {
		Product p = productDAO.findProductById(id);
		if(p!=null){
			productDAO.deleteProduct(p);
		}
	}
}
