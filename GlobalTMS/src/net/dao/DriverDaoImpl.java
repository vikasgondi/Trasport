package net.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.model.Driver;
@Repository("driverDao")
public class DriverDaoImpl implements DriverDao {
	
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> listDriver() {
		// TODO Auto-generated method stub
		
		return (List<Driver>)sessionFactory.getCurrentSession().createCriteria(Driver.class).list();
		
	}

}
