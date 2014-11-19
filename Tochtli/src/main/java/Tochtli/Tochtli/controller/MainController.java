package Tochtli.Tochtli.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Tochtli.Tochtli.model.pojo.Contact;
import Tochtli.Tochtli.model.services.EmailService;

@Controller
@SessionAttributes
public class MainController {

	@RequestMapping(value = "/")
	public ModelAndView home(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/history")
	public ModelAndView history(HttpServletResponse response)
			throws IOException {
		return new ModelAndView("history");
	}

	@RequestMapping(value = "/admin")
	public ModelAndView admin(HttpServletResponse response) throws IOException {
		return new ModelAndView("admin");
	}

	@RequestMapping("/contact")
	public ModelAndView showContacts() {
		// The spring framework expects an object with name command if you are
		// using <form:form> in your JSP file.
		return new ModelAndView("contact", "command", new Contact());
	}

	@RequestMapping(value = "/contactTochtli", method = RequestMethod.POST)
	public String contactTochtli(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		// System.out.println(contact.toString());

		// we may use templates
		String message = "Sender : " + contact.getName() + "\n";
		message += "Phone : " + contact.getPhone() + "\n";
		message += "Email : " + contact.getEmail() + "\n";
		message += "Message : " + contact.getMessage() + "\n";
		EmailService.sendEmail(EmailService.tochtliEmail, null,
				contact.getEmail(), "Somebody Contacted", message);

		return "redirect:"; // home page
	}

}
