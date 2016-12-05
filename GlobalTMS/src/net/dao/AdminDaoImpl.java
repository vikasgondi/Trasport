package net.dao;
import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.DocumentException;

import net.model.Admin;
import net.model.Booking;
import net.model.Driver;
import net.model.SpareDriver;
@Repository("admindao")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionfactory;
	@Autowired
	private CreateFile create;
	@Override
	public void registerDriver(Driver driver) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(driver);
		
	}
	@Override
	public boolean loginAdmin(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("In Check login");
		Session session = sessionfactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from Admin as o where o.u_name=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,email);
		query.setParameter(1,password);
		List<Admin> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		System.out.println("Done");
		return userFound; 
	}
	@Override
	public List<SpareDriver> regSPareDriver(SpareDriver spareD) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(spareD);
		return (List<SpareDriver>)sessionfactory.getCurrentSession().createCriteria(SpareDriver.class).add(Restrictions.eq("id", spareD.getId())).list();
	}
	@Override
	public List<SpareDriver> listSpare() {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().createCriteria(SpareDriver.class).list();
		
	}
	@Override
	public boolean checkDriver(int id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Criteria cr=session.createCriteria(SpareDriver.class);
		cr.add(Restrictions.eq("id", id));
		List<SpareDriver> list=cr.list();
		if(list==null)
		{
		return false;
		}
		else 
		{
			return true;
		}
	}
	@Override
	public List<Booking> allotSpare(Booking booking) throws IOException, DocumentException {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();
		
		Booking book=(Booking)session.get(Booking.class, booking.getB_id());
		SpareDriver spare=(SpareDriver)session.get(SpareDriver.class, booking.getSpareD().getId());
		book.setSpareD(spare);
		session.saveOrUpdate(book);
		create.createfileDriver(book);
		return session.createCriteria(Booking.class).add(Restrictions.eq("b_id", booking.getB_id())).list();
		
		
	}
	@Override
	public void updateDriver(Driver driver) {
		// TODO Auto-generated method stub
		System.out.println(driver.getDriver_id());
		System.out.println(driver.getD_name());
		Session sesion=sessionfactory.openSession();
		Transaction tx=sesion.getTransaction();
		tx.begin();
		sesion.update(driver);
	tx.commit();
	
	
		
		
	}
	public Driver getDriver(int id)
	{
		Session session=sessionfactory.openSession();
		Driver driver=(Driver)session.load(Driver.class, id);
		
		return driver;
	}
	@Override
	public void removeDriver(int id) {
		// TODO Auto-generated method stub
	System.out.println(id);
		Session session=sessionfactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Driver driver=(Driver)session.load(Driver.class, id);
		if(null!=driver)
		{
			session.delete(driver);
			tx.commit();
			
		}
	}
	@Override
	public SpareDriver getSapreDriver(int id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		SpareDriver driver=(SpareDriver)session.load(SpareDriver.class, id);
		
		return driver;
	}
	@Override
	public void updateSpareDriver(SpareDriver spareD) {
		// TODO Auto-generated method stub
		Session sesion=sessionfactory.openSession();
		Transaction tx=sesion.getTransaction();
		tx.begin();
		sesion.update(spareD);
	tx.commit();
	}
	@Override
	public void removeSpare(int id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		SpareDriver driver=(SpareDriver)session.load(SpareDriver.class, id);
		if(null!=driver)
		{
			session.delete(driver);
			tx.commit();
			
		}
	}
	
	
}
