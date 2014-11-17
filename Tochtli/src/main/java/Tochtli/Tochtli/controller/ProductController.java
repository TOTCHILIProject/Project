package Tochtli.Tochtli.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Product;
import Tochtli.Tochtli.model.services.ProductCategoryService;

@Controller
public class ProductController {

	@Autowired
	private ProductCategoryService productService;

	/*Retrive all categories*/
	@RequestMapping(value = "/galery")
	public ModelAndView galery(HttpServletResponse response) throws IOException {
		ModelAndView galeryView = new ModelAndView("galery");
		List<Category> categories = productService.findAllCategories();

		/*for(Product p : products)
			System.out.println(p.getName());*/
		
		galeryView.addObject("categories", categories);
		return galeryView;

	}

}
