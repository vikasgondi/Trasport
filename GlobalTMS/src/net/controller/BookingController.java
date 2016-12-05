package net.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.model.Booking;
import net.model.Customer;
import net.model.Driver;
import net.service.BookingService;
import net.service.CustomerService;











import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private	BookingService bookingService;
	@Autowired
	private CustomerService customerService;
	
@RequestMapping( method=RequestMethod.GET)
public ModelAndView book(@ModelAttribute("booking") Booking booking,HttpSession session, BindingResult result)
{
	//System.out.println(booking.getCustomer().getEmail());
	Customer cust=(Customer)session.getAttribute("CUSTOMER");
	System.out.println(cust.getEmail());
	
	return new ModelAndView("CustomerHome");
}
@RequestMapping(method= RequestMethod.POST)
public ModelAndView saveBooking(@Valid @ModelAttribute("booking") Booking booking,@ModelAttribute("customer") Customer customer,HttpSession session,  BindingResult result)
{
	
	Customer cust=(Customer)session.getAttribute("CUSTOMER");
	System.out.println("VIkas");
	System.out.println("Customer Name="+cust.getEmail());
	try{
		
		
		System.out.println("Customer E mail:"+cust.getEmail());
		System.out.println("name"+cust.getName());
		booking.setCustomer(cust);
		bookingService.ebook(booking);
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("bookings",  bookingService.bookdetail(booking.getB_id()));
				
			System.out.println("Done");
			
			
			
			
	
		
		return new ModelAndView("Bdone",model);
	}
	catch(Exception e)
	{
		System.out.println("catch");
		
		return new ModelAndView("addbooking");
	}
	
	
}
@RequestMapping(value="confirm/{id}", method= RequestMethod.GET)
public ModelAndView confirmBook(@PathVariable("id") long id,@ModelAttribute("booking") Booking booking,BindingResult result) throws ParseException, IOException, DocumentException
{
	System.out.println(booking.getB_id());
	//System.out.println(booking.getCustomer().getEmail());
	System.out.println(booking.getV_type());
	System.out.println("Start Date"+booking.getS_date());
	System.out.println("End Date"+booking.getE_date());
	
	booking.setB_id(id);
	
	
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("bookings",bookingService.allotd(booking));
		
	System.out.println("done");
	return new ModelAndView("confirm",model);
}

@RequestMapping(value="mybook",method=RequestMethod.GET)
public ModelAndView mybook(@ModelAttribute("booking") Booking booking,HttpSession session,BindingResult result)
{
	Customer cust=(Customer)session.getAttribute("CUSTOMER");
	System.out.println("myBook");
	System.out.println("Customer Name="+cust.getEmail());
	Map<String, Object> model = new HashMap<String, Object>();
	model.put("bookings1", bookingService.custDetails(cust));
	return new ModelAndView("custBookingD",model);
}
}
 