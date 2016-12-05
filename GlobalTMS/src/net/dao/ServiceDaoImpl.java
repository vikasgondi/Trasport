package net.dao;

import java.util.List;

import javax.transaction.Transactional;

import net.model.Booking;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("serviceDao")
public class ServiceDaoImpl implements ServiceDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public boolean loginService(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("In Check login");
		Session session = sessionfactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from ServiceDesk as o where o.user_id=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,email);
		query.setParameter(1,password);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		System.out.println("Done");
		return userFound; 
	}
	@Override
	public void billAmount(Booking booking) {
		// TODO Auto-generated method stub
		Integer temp=booking.getE_kms()-booking.getS_kms();
		Integer amount=(int) ((temp*15)-booking.getE_amount());
		Session session=sessionfactory.openSession();
		Transaction tx= session.beginTransaction();
		Booking book=(Booking)session.get(Booking.class, booking.getB_id());
		book.setS_kms(booking.getS_kms());
		book.setE_kms(booking.getE_kms());
		amount=(int) (amount-book.getE_amount());
		book.setT_amount(amount);
		book.setStatus("Completed");
		session.saveOrUpdate(book);
		tx.commit();
		
   	session.close();
      
		
	}

}
