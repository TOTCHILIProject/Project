package Tochtli.Tochtli.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.services.ProductCategoryService;

@Controller
@RequestMapping("/")
@SessionAttributes({ "order" })
@Scope("session")
public class OrderController {

	@Autowired
	private ProductCategoryService productService;

	private Order order = new Order();

	@RequestMapping("/galery/addToCart")
	public ModelAndView addToCart(@RequestParam("id") long idProduct, @RequestParam("quantity") int quantity,
			@RequestParam("categId") long categId) {
		String msg = productService.addToCart(order, quantity, idProduct);

		ModelAndView galeryDetailView = new ModelAndView("detailCategory");
		Category category = productService.getCategoryById(categId);

		galeryDetailView.addObject("message", msg);
		galeryDetailView.addObject("category", category);
		return galeryDetailView;

	}
	
	@RequestMapping("/shoppingCart")
	public ModelAndView shoppingCart(HttpServletResponse response) throws IOException {
		return new ModelAndView("shoppingCart");
	}
	
}
