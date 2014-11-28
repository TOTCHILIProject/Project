package Tochtli.Tochtli.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Tochtli.Tochtli.model.entity.Category;
import Tochtli.Tochtli.model.entity.Order;
import Tochtli.Tochtli.model.entity.User;
import Tochtli.Tochtli.model.services.OrderService;
import Tochtli.Tochtli.model.services.ProductCategoryService;

@Controller
@RequestMapping("/")
@SessionAttributes({ "order" })
@Scope("session")
public class OrderController {

	@Autowired
	private ProductCategoryService productService;

	@Autowired
	private OrderService orderService;

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
	public ModelAndView shoppingCart(@RequestParam(required = false) boolean ok) throws IOException {
		ModelAndView shoppingCartView = new ModelAndView("shoppingCart");

		shoppingCartView.addObject("order", order);
		if (ok) {
			shoppingCartView.addObject("message", "Thank you for ordering!");
		}
		shoppingCartView.addObject("command", new User());
		return shoppingCartView;
	}

	@RequestMapping("/removeFromCart")
	public String shoppingCart(@RequestParam("id") long idProduct) throws IOException {
		productService.removeFromCart(order, idProduct);

		return "redirect:" + "shoppingCart";
	}

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public ModelAndView contactTochtli(@ModelAttribute("user") User user, BindingResult result) {

		order.setUser(user);
		orderService.placeOrder(order);
		// new order
		order = new Order();

		return new ModelAndView("redirect:/shoppingCart?ok=true");
	}
}
