package net.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.model.Booking;
import net.model.Customer;
import net.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class RegisterController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/save" ,method = RequestMethod.POST)
	public ModelAndView saveArticle(@Valid @ModelAttribute("customer") Customer  customer,BindingResult result, @ModelAttribute("booking") Booking booking,
			HttpSession session ) {
	
		if (result.hasErrors()) {
			 System.out.println("Error");
			    return new ModelAndView("addCustomer");
			    }
		
		try
		{
		 customerService.signUp(customer);
		
		 		session.setAttribute("CUSTOMER", customer);
				return new ModelAndView("CustomerHome");
		}
		catch(Exception e) 
		{
			
			
			
			System.out.println("controller");
			String msg= "User ALready Exists with email id. Login with e mail id or use diffrent e mail"; 
			
			
		
			 
			
			 return new ModelAndView("addCustomer","mymsg",msg);
		}
	
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addArticle(@ModelAttribute("customer") Customer customer,
			BindingResult result) {
		
		System.out.println("five");
		return new ModelAndView("addCustomer");
	}
	@RequestMapping(value="listcustomer", method=RequestMethod.GET)
	public ModelAndView listCustomer(@ModelAttribute("customer") Customer customer, BindingResult result)
	{
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("customers",  customerService.listCustomers());
		return new ModelAndView("customerdetail",model);
	}
	
}
