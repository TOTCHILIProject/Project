package Tochtli.Tochtli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import Tochtli.Tochtli.model.services.ProductCategoryService;

@Controller
@RequestMapping("/")
@SessionAttributes({ "order" })
public class OrderController {

	@Autowired
	private ProductCategoryService productService;

}
