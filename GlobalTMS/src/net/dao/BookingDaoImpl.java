package net.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.model.Booking;
import net.model.Customer;
import net.model.Driver;
@Repository("bookingDao")
public class BookingDaoImpl implements BookingDao{

	@Autowired
	private SessionFactory sessionfactory;
	@Autowired
	private JavaMailSender mail;
	@Autowired 
	private MailSender sender;
	@Autowired
	private CreateFile create;
	@Override
	
	
	public void book(Booking booking) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Fuck"+booking.getCustomer().getEmail());
		Customer customer=(Customer) sessionfactory.getCurrentSession().get(Customer.class, booking.getCustomer().getEmail());
		booking.setCustomer(customer);
		String vtype=booking.getV_type().toLowerCase();
		int a=1;
		if(vtype.equalsIgnoreCase("indica"))
		{
			a=8;
		}
		else if((vtype.equalsIgnoreCase("innova"))||(vtype.equalsIgnoreCase("scorpio")))
		{
			a=11;
		}
		else if((vtype.equalsIgnoreCase("swiftDesire"))||(vtype.equalsIgnoreCase("Etios")))
		{
			a=9;
		}
		else if(vtype.equalsIgnoreCase("TempoTraveller"))
		{
			a=13;
		}
		
	booking.setE_amount(booking.calculate(booking.getS_date(), booking.getE_date(),a));
		
		sessionfactory.getCurrentSession().save(booking);
		
	}

	@Override
	public List<Booking> bookd(long bid) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		
		Criteria cr = session.createCriteria(Booking.class);
        // Add restriction.
       cr.add(Restrictions.eq("b_id", bid));
       @SuppressWarnings("unchecked")
	List<Booking> list= cr.list();
       return list;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Booking> listBooking() {
		System.out.println("nine");
		
		Session session= sessionfactory.openSession();
		Criteria cr= session.createCriteria(Booking.class);
		cr.add(Restrictions.lt("e_date", new Date(2011, 01, 1)));
		//cr.setProjection(Projections.projectionList()
				//.add(Projections.groupProperty("driver.driver_id")));
		return (List<Booking>) cr.list();
	//return (List<Booking>) sessionfactory.getCurrentSession().createCriteria(Booking.class).addOrder(org.hibernate.criterion.Order.asc("b_id")).list();
				
	}

	@Override
	public List<Booking> allot(Booking booking) throws ParseException {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		//System.out.println(booking.getS_date());
		Transaction tx=null;
	
			
		tx= session.beginTransaction();
				
			Booking book= (Booking)session.get(Booking.class, booking.getB_id());
		Criteria cr= session.createCriteria(Driver.class);
		cr.add(Restrictions.eq("vehicle_type",book.getV_type()).ignoreCase());
		
		cr.add(Restrictions.lt("e_date",book.getS_date()));
		
		//cr.addOrder(org.hibernate.criterion.Order.asc("e_date"));
		cr.setMaxResults(1);
		Driver driver= (Driver)cr.uniqueResult();
		if(driver==null)
		{
			
			try {
				create.createfile(book,false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String path="D:\\Invoice1\\"+Long.toString(book.getB_id())+".pdf";
		//sender.sendMail("vikasgondi@outlook.com", "gondivikas@gmail.com", Long.toString(book.getB_id()), "Admin find car and driver", path);	
		//sender.sendMail("vikasgondi@outlook.com", book.getCustomer().getEmail(), Long.toString(book.getB_id()),"Please find your invoice in attachment. Thank you.. Global Transport System",path);
		}
		else
		{
		driver.setS_date(book.getS_date());
		driver.setE_date(book.getE_date());
		book.setDriver(driver);
		session.saveOrUpdate(driver);
		session.saveOrUpdate(book);
		tx.commit();
		try {
			create.createfile(book,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path="D:\\Invoice1\\"+Long.toString(book.getB_id())+".pdf";
		//sendMail("vikasgondi@outlook.com", "gondivikas@gmail.com", Long.toString(book.getB_id()), "Admin auto driver alloted", path);	
		//sendMail("vikasgondi@outlook.com", book.getCustomer().getEmail(), Long.toString(book.getB_id()),"Please find your invoice in attachment. Thank you.. Global Transport System",path);
		
		System.out.println(driver.getE_date());
		}
		
		
		
		Criteria boo=session.createCriteria(Booking.class);
		boo.add(Restrictions.eq("b_id",book.getB_id()));
		@SuppressWarnings("unchecked")
		List<Booking> bb=boo.list();
		session.close();
		return bb;
		}

	@Override
	public List<Booking> bidDetail(Booking booking) {
		// TODO Auto-generated method stub
		
		
		return (List<Booking>)sessionfactory.getCurrentSession().createCriteria(Booking.class).add(Restrictions.eq("b_id", booking.getB_id())).list();
	}

	@Override
	public List<Booking> custDetail(Customer customer) {
		
		// TODO Auto-generated method stub
		System.out.println(customer.getEmail());
		Session session=sessionfactory.openSession();
		Criteria cr= session.createCriteria(Booking.class);
		cr.add(Restrictions.eq("customer.email", customer.getEmail()));
		List<Booking> list=cr.list();
		return list;
	}

	@Override
	public List<Booking> dBookingDetail(Driver driver) {
		// TODO Auto-generated method stub
		return (List<Booking>)sessionfactory.getCurrentSession().createCriteria(Booking.class).add(Restrictions.eq("driver.driver_id", driver.getDriver_id())).list();
	}

	

	@Override
	public boolean checkBook(long bid) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Criteria cr=session.createCriteria(Booking.class);
		cr.add(Restrictions.eq("b_id", bid));
		List<Booking> list=cr.list();
		if(list!=null)
		{
			return true;
		}
		else{
		return false;
	}
	}

}
