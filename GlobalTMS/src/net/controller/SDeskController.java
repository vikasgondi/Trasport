package net.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.model.Booking;
import net.model.Customer;
import net.model.Driver;
import net.model.ServiceDesk;
import net.service.BookingService;
import net.service.DeskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service")
public class SDeskController {
	@Autowired
	private DeskService deskService;
	@Autowired
	private BookingService bookservice;
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loginService(@ModelAttribute("serviceDesk") ServiceDesk serviceDesk,BindingResult result)
	{
		return new ModelAndView("servicelogin");
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("serviceDesk")ServiceDesk serviceDesk,@ModelAttribute("booking")Booking booking,BindingResult result)
	{
		boolean check= deskService.loginServiceDesk(serviceDesk.getUser_id(), serviceDesk.getPassword());
		if (check)
		{
			return new ModelAndView("serviceHome");
		}
		else
		{
			String msg="Sorry User name or password invalid";
			return new ModelAndView("servicelogin","mymsg",msg);
		}
		
	
	}
	@RequestMapping(value="home", method=RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("serviceDesk")ServiceDesk serviceDesk,@ModelAttribute("booking") Booking booking,BindingResult result)
	{
		return new ModelAndView("serviceHome");
	}
	
	@RequestMapping(value="bill",method=RequestMethod.GET)
	public ModelAndView bill(@ModelAttribute("booking")Booking booking,BindingResult result)
	{
		return new ModelAndView("checkbill");
	}
	@RequestMapping(value="dobill",method=RequestMethod.POST)
	public ModelAndView checkBill(@ModelAttribute("booking")Booking booking,BindingResult result)
	{
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("bookings",  bookservice.bookdetail(booking.getB_id()));
			
			System.out.println("Done");
		return new ModelAndView("billamount",model);
	}
	@RequestMapping(value="finalbill",method=RequestMethod.POST)
	public ModelAndView finalbill(@ModelAttribute("booking")Booking booking,BindingResult result)
	{
		
		deskService.billAmounta(booking);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("bookings",  bookservice.bookdetail(booking.getB_id()));
			
		return new ModelAndView("finalbill",model);
	}
	@RequestMapping(value="paid", method=RequestMethod.POST)
	public ModelAndView paid(@ModelAttribute("booking")Booking booking,BindingResult result)
	{
		String msg="Succesful Payment";
		return new ModelAndView("serviceHome","mymsg",msg);
	}
	@RequestMapping(value="logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return ("servicelogin.jsp");
	}
	@RequestMapping(value="bookdetail",method=RequestMethod.POST)
	public ModelAndView bookdetail(@ModelAttribute("booking")Booking booking,@ModelAttribute("customer") Customer customer, @ModelAttribute("driver") Driver driver,BindingResult result)
	{
		System.out.println(customer.getEmail());
		Map<String, Object> model = new HashMap<String, Object>();
		Long temp=booking.getB_id();
		Integer temp1=driver.getDriver_id();
		if(temp>0)
		{
			System.out.println("1");
			List<Booking> book=bookservice.bidDetails(booking);
			if((book!=null)&(book.size()>0))
			{
		model.put("bookings", book);
		return new ModelAndView("serviceBookingD",model);
			}
			
			String msg="Invalid Data";
			return new ModelAndView("serviceBDetail","mymsg",msg);
		}
		else if(customer.getEmail()!=null)
		{
			System.out.println(customer.getEmail());
			List<Booking> book=bookservice.custDetails(customer);
			if((book!=null)&(book.size()>0))
			{
		model.put("bookings1", book);
		return new ModelAndView("serviceBookingD",model);
			}
			
			String msg="Invalid Data";
			return new ModelAndView("serviceBDetail","mymsg",msg);
		}
		else if(temp1!=null&& temp1>0)
		{
			List<Booking> book=bookservice.dBookingDetails(driver);
			if((book!=null)&(book.size()>0))
			{
		model.put("bookings1", book);
		return new ModelAndView("serviceBookingD",model);
			}
			
			String msg="Invalid Data";
			return new ModelAndView("serviceBDetail","mymsg",msg);
			
		}
		else
		{
			String msg="Invalid Data";
			return new ModelAndView("serviceBDetail","mymsg",msg);
			
		}
		
	}
	@RequestMapping(value="bookdetail",method=RequestMethod.GET)
	public ModelAndView bookdetail2(@ModelAttribute("booking")Booking booking,@ModelAttribute("customer") Customer customer,@ModelAttribute("driver") Driver driver,BindingResult result)
	{
		return new ModelAndView("serviceBDetail");
		
	}
}
