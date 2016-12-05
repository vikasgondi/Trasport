package net.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;






import net.dao.BookingDao;
import net.model.Booking;
import net.model.Customer;
import net.model.Driver;
@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDao bookingDao;
	@Autowired
private JavaMailSender mail;
	
	public MailSender getMail() {
		return mail;
	}

	public void setMail(JavaMailSender mail) {
		this.mail = mail;
	}
	@Override
	@Transactional
	public void ebook(Booking booking) throws Exception {
		// TODO Auto-generated method stub
		bookingDao.book(booking);
		
	}
	@Override
	public List<Booking> bookdetail(long bid) {
		// TODO Auto-generated method stub
		return bookingDao.bookd(bid);
	}
	
	public List<Booking> listBookings() 
	{
		System.out.println("15");
		return bookingDao.listBooking();
	}

	@Override
	public List<Booking> allotd(Booking booking) throws ParseException {
		// TODO Auto-generated method stub
		 return bookingDao.allot(booking);
	}

	@Override
	public List<Booking> bidDetails(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.bidDetail(booking);
	}

	@Override
	public List<Booking> custDetails(Customer customer) {
		// TODO Auto-generated method stub
		return bookingDao.custDetail(customer);
	}

	@Override
	public List<Booking> dBookingDetails(Driver driver) {
		// TODO Auto-generated method stub
		return bookingDao.dBookingDetail(driver);
	}

	@Override
	public boolean checkBooks(long bid) {
		// TODO Auto-generated method stub
		return bookingDao.checkBook(bid);
	}



}
