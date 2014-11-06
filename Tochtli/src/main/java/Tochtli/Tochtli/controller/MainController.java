package Tochtli.Tochtli.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public ModelAndView home(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/history")
	public ModelAndView history(HttpServletResponse response) throws IOException{
		return new ModelAndView("history");
	}
	
	@RequestMapping(value="/galery")
	public ModelAndView galery(HttpServletResponse response) throws IOException{
		return new ModelAndView("galery");
	}
	
}