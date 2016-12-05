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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private CustomerService customerService;

	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView loginCustomer(@ModelAttribute("customer") Customer customer, BindingResult result)
	{
	
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("customer") Customer customer,BindingResult result,@ModelAttribute("booking") Booking booking,HttpSession session ) 
	{
		if(result.hasErrors())
		{
			System.out.println("Login Error");
			return new ModelAndView("login");
		}
		
		boolean userExists = customerService.login(customer.getEmail(),customer.getPassword());
		if (userExists)
		{
			System.out.println("Successful Login");
			Map<String, Object> model=new HashMap<String, Object>();
			model.put("customers", customerService.custDetail(customer.getEmail()));
			System.out.println(customer.getEmail());
			session.setAttribute("CUSTOMER", customer);
			return new ModelAndView("CustomerHome",model);
		}
		else
		{
			
				String msg="Sorry Email or password invalid";
					return new ModelAndView("login","mymsg",msg);
		}
	}
	@RequestMapping(value="logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return ("login.jsp");
	}
}
