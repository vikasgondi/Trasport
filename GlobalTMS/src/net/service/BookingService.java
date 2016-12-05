package net.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import net.model.Booking;
import net.model.Customer;
import net.model.Driver;

public interface BookingService {
	
	public void ebook(Booking booking) throws Exception;
	public List<Booking> bookdetail(long bid);
	
	public List<Booking> listBookings();
	public List<Booking> allotd(Booking booking) throws ParseException;
	public List<Booking> bidDetails(Booking booking);
	public List<Booking> custDetails(Customer customer);
	public List<Booking> dBookingDetails(Driver driver);
	public boolean checkBooks(long bid);
	
}
