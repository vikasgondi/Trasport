package net.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.model.Admin;
import net.model.Booking;
import net.model.Customer;
import net.model.Driver;
import net.model.SpareDriver;
import net.service.AdminService;
import net.service.BookingService;
import net.service.CustomerService;
import oracle.sql.BINARY_DOUBLE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.DocumentException;
import com.sun.mail.handlers.message_rfc822;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loginadmin(@ModelAttribute("admin") Admin admin, BindingResult result)
	{
		return new ModelAndView("AdminLogin");
	}
	@RequestMapping(value="loginadmin", method=RequestMethod.POST)
	public ModelAndView verifyadmin(@ModelAttribute("admin") Admin admin, BindingResult result)
	{
		boolean userExists = adminService.loginadmin(admin.getU_name(), admin.getPassword());
		if (userExists)
		{
			return new ModelAndView("AdminHome");
		}
		else
		{
			String msg="Sorry User name or password invalid";
			return new ModelAndView("AdminLogin","mymsg",msg);
		}
		
	}
	@RequestMapping(value="home", method=RequestMethod.GET)
	public ModelAndView rehome(@ModelAttribute("admin") Admin admin, BindingResult result)
	{
		return new ModelAndView("AdminHome");
	}
	
	@RequestMapping(value="driver/add", method=RequestMethod.GET)
	public ModelAndView registerDriver(@ModelAttribute("driver") Driver driver, BindingResult result)
	{
		return new ModelAndView("AdminAddDriver");
	}
	@RequestMapping(value="driver/list", method=RequestMethod.GET)
	public ModelAndView listDriver(@ModelAttribute("driver") Driver driver, BindingResult result)
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("drivers", adminService.listDrivers());
		
		return new ModelAndView("AdminDriverSaved", model);
	}
	@RequestMapping(value="driver/add", method=RequestMethod.POST)
	public ModelAndView saveDriver(@Valid @ModelAttribute("driver") Driver driver, BindingResult result)
	{
		if (result.hasErrors()) {
			 System.out.println("Error");
			    return new ModelAndView("AdminAddDriver");
			    }
		try{
			
		
		adminService.regDriver(driver);
		return new ModelAndView("AdminDriverSaved");
		}
		catch(Exception e)
		{
			String msg="Driver already exist with e mail or Vehicle No";
			return new ModelAndView("AdminAddDriver","mymsg",msg);
		}
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return ("AdminLogin.jsp");
	}
	
	@RequestMapping(value="booking/{id}", method=RequestMethod.GET)
	public ModelAndView bDetails(@PathVariable("id") int id,@ModelAttribute("booking")Booking booking,@ModelAttribute("customer") Customer customer,@ModelAttribute("driver") Driver driver,BindingResult result)
	{
		ModelAndView model= new ModelAndView();
		
		if(id==1)
		{
			
			model.addObject("byid", "Booking");
		}
		else if(id==2)
		{
			model.addObject("cust", "Customer");
		}
		else if(id==3)
		{
			model.addObject("driver1", "Driver");
		}
		model.setViewName("AdminBookingHome");
				
		return model;
	}
	
	@RequestMapping(value="bdetail" , method=RequestMethod.POST)
	public ModelAndView bdetail(@ModelAttribute("booking")Booking booking,@ModelAttribute("customer") Customer customer,@ModelAttribute("driver") Driver driver,BindingResult result)
	{
		System.out.println(customer.getEmail());
		Map<String, Object> model = new HashMap<String, Object>();
		Long temp=booking.getB_id();
		Integer temp1=driver.getDriver_id();
		if(temp>0)
		{
			System.out.println("1");
			List<Booking> book=bookingService.bidDetails(booking);
			if((book!=null)&(book.size()>0))
			{
		model.put("bookings", book);
		return new ModelAndView("AdminBookings",model);
			}
			
			String msg="Invalid Data";
			return new ModelAndView("AdminBookingHome","mymsg",msg);
		}
		else if(customer.getEmail()!=null)
		{
			System.out.println(customer.getEmail());
			List<Booking> book=bookingService.custDetails(customer);
			if((book!=null)&(book.size()>0))
			{
		model.put("bookings1", book);
		return new ModelAndView("AdminBookings",model);
			}
			
			String msg="Invalid Data";
			return new ModelAndView("AdminBookingHome","mymsg",msg);
		}
		else if(temp1!=null&& temp1>0)
		{
			List<Booking> book=bookingService.dBookingDetails(driver);
			if((book!=null)&(book.size()>0))
			{
		model.put("bookings1", book);
		return new ModelAndView("AdminBookings",model);
			}
			
			String msg="Invalid Data";
			return new ModelAndView("AdminBookingHome","mymsg",msg);
			
		}
		else
		{
			String msg="Invalid Data";
			return new ModelAndView("AdminBookingHome","mymsg",msg);
			
		}
		
			
	}
	@RequestMapping(value="booking/list", method= RequestMethod.GET)
	public ModelAndView listBook(@ModelAttribute("booking") Booking booking, BindingResult result)
	{
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("bookingss",  bookingService.listBookings());
		
		return new ModelAndView("AdminBookings",model);
	}
	
	@RequestMapping(value="sparedriver/add",method=RequestMethod.GET)
	public ModelAndView spareD(@ModelAttribute("spareD") SpareDriver spareD,BindingResult result)
	{
		return new ModelAndView("addSpareDriver");
	}
	
	
	@RequestMapping(value="sparedriver/add", method=RequestMethod.POST)
	public ModelAndView saveSpareD(@Valid @ModelAttribute("spareD") SpareDriver spareD, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("AdminAddSpareD");
		}
		try
		{
			Map<String, Object> model= new HashMap<String, Object>();
			model.put("drivers", adminService.regSPareDriver(spareD));
			
			return new ModelAndView("AdminSpareDSaved",model);
			
		}
		catch(Exception e)
		{
			String msg="Driver Already exists with same Id";
			return new ModelAndView("AdminAddSpareD","mymsg",msg);
		}
	}

	
	
	
	
		
	@RequestMapping(value="spare/list")
	public ModelAndView spareList(@ModelAttribute("spareD") SpareDriver spareD,BindingResult result)
	{
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("drivers", adminService.listSpares());
		return new ModelAndView("AdminSpareDDetail",model);
	}
	
	
	@RequestMapping(value="spare/allot")
	public ModelAndView allotDriver(@ModelAttribute("spareD") SpareDriver spareD,@ModelAttribute("booking") Booking booking,BindingResult result)
	{
		return new ModelAndView("AdminAllotDriver");
	}
	
	
	@RequestMapping(value="spare/allot", method=RequestMethod.POST)
	public ModelAndView allot(@ModelAttribute("booking") Booking booking,BindingResult result) throws IOException, DocumentException
	{
		try{
			/*adminService.allotSpares(booking);*/
			Map<String, Object> model= new HashMap<String, Object>();
			model.put("bookings",adminService.allotSpares(booking));
			return new ModelAndView("AdminAllotSpareDone",model);
		}
		catch(Exception e)
		{
			String msg="Booking id or Driver id is not valid";
		return new ModelAndView("AdminAllotDriver","mymsg",msg);
		}
	}
	/*
	@RequestMapping(value="driver",method=RequestMethod.GET)
	public ModelAndView driver(@ModelAttribute("driver") Driver driver,BindingResult result)
	{
		return new ModelAndView("driverHome");
	}*/
	
	@RequestMapping(value="driver/{id}/update")
	public ModelAndView updateDriver(@PathVariable("id") int id, @ModelAttribute("driver") Driver driver,BindingResult result)
	{
	
		ModelAndView model= new ModelAndView();
		model.addObject("driver", adminService.getDriver(id));
		model.setViewName("AdminUpdateDriver");
 		return model;
	}
	
	
	@RequestMapping(value="driver/update")
	public ModelAndView updateDriverbyID(@ModelAttribute("driver") Driver driver,BindingResult result)
	{
		adminService.updateDriver(driver);
		ModelAndView model= new ModelAndView();
		model.addObject("drivers", adminService.listDrivers());
		model.addObject("mymsg", "Updated Successfully");
		model.setViewName("AdminDriverSaved");
		return model;
	}

	
	@RequestMapping(value="driver/{id}/delete")
	public ModelAndView deleteDriver(@PathVariable("id") int id,@ModelAttribute("driver") Driver driver,BindingResult result)
	{
		ModelAndView model=new ModelAndView();
		try{
		adminService.removeDriver(id);
		model.addObject("mymsg", "Deleted Successfully");
		}
		catch(Exception e){
			
			System.out.println("Cant delete Driver");
			model.addObject("mymsg", "Cant delete Driver");
		}
		
		model.addObject("drivers",adminService.listDrivers());
		model.setViewName("AdminDriverSaved");

		return model;
	}
	
	
	@RequestMapping(value="spare/{id}/update")
	public ModelAndView updateSpareGet(@PathVariable("id") int id,@ModelAttribute("spareD") SpareDriver spareD,BindingResult result)
	{
		ModelAndView model= new ModelAndView();
		model.addObject("spareD", adminService.getSpareDriver(id));
		model.setViewName("AdminAddSpareD");
		return model;
	}
	
	
	@RequestMapping(value="spare/update")
	public ModelAndView updateSpare(@ModelAttribute("spareD") SpareDriver spareD,BindingResult result)
	{
		adminService.updateSpareDriver(spareD);
		ModelAndView model= new ModelAndView();
		model.addObject("drivers", adminService.listSpares());
		model.setViewName("AdminSpareDDetail");
		model.addObject("mymsg", "Updated Successfully");
		return model;
	}
	
	
	@RequestMapping(value="spare/{id}/delete")
	public ModelAndView deleteSpare(@PathVariable("id") int id,@ModelAttribute("spareD")SpareDriver spareD,BindingResult result)
	{
		ModelAndView model= new ModelAndView();
		try{
			adminService.removeSpare(id);
			
		}
		catch(Exception e)
		{
			model.addObject("mymsg", "Sorry cant delete");
		}
	
		
		model.addObject("drivers", adminService.listSpares());
		model.setViewName("AdminSpareDDetail");
	
		return model;
	}
	@RequestMapping(value="listcustomer", method=RequestMethod.GET)
	public ModelAndView listCustomer(@ModelAttribute("customer") Customer customer, BindingResult result)
	{
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("customers",  customerService.listCustomers());
		return new ModelAndView("AdminCustDetail",model);
	}
}
