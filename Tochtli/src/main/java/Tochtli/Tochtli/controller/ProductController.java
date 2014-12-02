package Tochtli.Tochtli.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Product;
import Tochtli.Tochtli.model.services.ProductCategoryService;

@Controller
public class ProductController {

	@Autowired
	private ProductCategoryService productService;

	/* Retrieve all categories */
	@RequestMapping(value = "/galery")
	public ModelAndView galery(HttpServletResponse response) throws IOException {
		ModelAndView galeryView = new ModelAndView("galery");
		List<Category> categories = productService.findAllCategories();

		galeryView.addObject("categories", categories);
		return galeryView;

	}

	@RequestMapping(value = "/galery/{categId}", method = RequestMethod.GET)
	public ModelAndView detailCategory(@PathVariable Long categId) {

		ModelAndView galeryDetailView = new ModelAndView("detailCategory");
		Category category = productService.getCategoryById(categId);

		galeryDetailView.addObject("category", category);
		return galeryDetailView;
	}

	/* Retrieve all products */
	@RequestMapping(value = "/admin/products")
	public ModelAndView productAdmin(HttpServletResponse response) throws IOException {
		ModelAndView productAdminView = new ModelAndView("admin/productAdmin");
		List<Product> products = productService.findAllProducts();

		productAdminView.addObject("products", products);
		return productAdminView;

	}

	@RequestMapping(value = "/admin/products/edit/{productID}")
	public ModelAndView editProduct(@PathVariable Long productID) throws IOException {
		ModelAndView productEditView = new ModelAndView("admin/editProduct");

		Product product = productService.getProductById(productID);

		// form:form expects an object names command
		productEditView.addObject("command", product);
		productEditView.addObject("categories", productService.findAllCategories());
		return productEditView;

	}

	@RequestMapping(value = "/admin/products/add")
	public ModelAndView addProduct() throws IOException {
		ModelAndView productEditView = new ModelAndView("admin/editProduct");

		Product product = new Product();

		productEditView.addObject("command", product);
		productEditView.addObject("categories", productService.findAllCategories());
		return productEditView;

	}

	@RequestMapping(value = "/admin/products/activate/{productID}")
	public String activateProduct(@PathVariable Long productID) throws IOException {
		productService.deleteProduct(productID);

		return "redirect:" + "/admin/products";

	}

	@RequestMapping(value = "/admin/products/persistProduct", method = RequestMethod.POST)
	public String persistProduct(@ModelAttribute("product") Product product) {

		// System.out.println(contact.toString());

		Category categ = product.getCategory();
		// for some reason it creates a new object => we have to link the
		// product to the already existent categrory
		categ = productService.getCategoryById(categ.getId());
		product.setCategory(categ);

		productService.persistProduct(product);

		return "redirect:";

	}

	/* Retrieve all categories for admin */
	@RequestMapping(value = "/admin/categories")
	public ModelAndView categoryAdmin(HttpServletResponse response) throws IOException {
		ModelAndView categoriesAdminView = new ModelAndView("admin/categoryAdmin");
		List<Category> categories = productService.findAllCategories();

		categoriesAdminView.addObject("categories", categories);
		return categoriesAdminView;

	}

	@RequestMapping(value = "/admin/categories/persistCategories", method = RequestMethod.POST)
	public String persistCategory(@ModelAttribute("category") Category category) {

		if (category.getProducts() != null) {
			System.out.println(category.getProducts());
			for (Product p : category.getProducts()) {
				p.setCategory(category);
			}
		}
		productService.persistCategory(category);

		return "redirect:";

	}

	@RequestMapping(value = "/admin/categories/add")
	public ModelAndView addCategory() throws IOException {
		ModelAndView categoryEditView = new ModelAndView("admin/editCategory");

		Category category = new Category();

		categoryEditView.addObject("command", category);
		return categoryEditView;

	}

	@RequestMapping(value = "/admin/categories/edit/{categoryID}")
	public ModelAndView editCategory(@PathVariable Long categoryID) throws IOException {
		ModelAndView categoryEditView = new ModelAndView("admin/editCategory");

		Category category = productService.getCategoryById(categoryID);

		// form:form expects an object names command
		categoryEditView.addObject("command", category);
		return categoryEditView;

	}

	@RequestMapping(value = "/admin/categories/activate/{categoryID}")
	public String activateCategory(@PathVariable Long categoryID) throws IOException {
		productService.deleteCategory(categoryID);

		return "redirect:" + "/admin/categories";

	}
}
