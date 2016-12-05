package net.dao;



import java.util.List;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.model.Customer;
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void registerCustomer(Customer customer) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("six");
		
		sessionFactory.getCurrentSession().save(customer);
		/*Session session = sessionFactory.openSession();
		session.saveOrUpdate(customer);*/
		 /*int resultFlag = 0 ;
		 //   try {
		        // obtaining session is omitted
		    	sessionFactory.getCurrentSession().save(customer);
		        resultFlag = 1 ;    
		    } catch (Exception e) {
		       // e.printStackTrace();
		    
		    	
		    } */
		   // return resultFlag ;
			
/*	sessionFactory.getCurrentSession().saveOrUpdate(customer);
		System.out.println("eight");
		*/
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean loginCustomer(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from Customer as o where o.email=? and o.password=?";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Override
	public List<Customer> customerDetail(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria cr= session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("email", email));
		List<Customer> list=cr.list();
		session.close();
		return list;
	}
	
	

}
