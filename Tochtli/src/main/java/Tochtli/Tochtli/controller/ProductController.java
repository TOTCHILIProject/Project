package Tochtli.Tochtli.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	//private List<Category> categories; 

	/*Retrieve all categories*/
	@RequestMapping(value = "/galery")
	public ModelAndView galery(HttpServletResponse response) throws IOException {
		ModelAndView galeryView = new ModelAndView("galery");
		List<Category> categories = productService.findAllCategories();
		//categories = productService.findAllCategories();
		
		/**Category cat1 = new Category("First category");
		//cat1.setId(1);
		categories.add(cat1);
		
		Category cat2 = new Category("Second category");
		categories.add(cat2);
		
		Category cat3 = new Category("Third category");
		categories.add(cat3);*/
		
		/*for(Category p : categories)
			System.out.println(p.getProducts().size());
		*/
		galeryView.addObject("categories", categories);
		return galeryView;

	}
	
	/*Retrieve all products*/
	@RequestMapping(value = "/admin")
	public ModelAndView productAdmin(HttpServletResponse response) throws IOException {
		ModelAndView productAdminView = new ModelAndView("products");
		List<Product> products = productService.findAllProducts();
		
		productAdminView.addObject("products", products);
		return productAdminView;

	}
	
	@RequestMapping(value="/galery/{categId}", method=RequestMethod.GET)
	public ModelAndView detailCategory(@PathVariable Long categId) {
	    
	    ModelAndView galeryDetailView = new ModelAndView("detailCategory");
		Category category = productService.getCategoryById(categId);
		
		//category = categories.get(categId.intValue());

		galeryDetailView.addObject("category", category);
		return galeryDetailView;
	}

}
