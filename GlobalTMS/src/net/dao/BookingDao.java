package net.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import net.model.Booking;
import net.model.Customer;
import net.model.Driver;

public interface BookingDao {
	public void book(Booking booking) throws Exception;
	public List<Booking> bookd(long bid);
	public List<Booking> listBooking();
	public List<Booking> allot(Booking book_id) throws ParseException;
	public List<Booking> bidDetail(Booking booking);
	public List<Booking> custDetail(Customer customer);
	public List<Booking> dBookingDetail(Driver driver);
	
	public boolean checkBook(long bid);
	
}
 