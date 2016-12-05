package net.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import net.dao.AdminDao;
import net.dao.DriverDao;
import net.model.Booking;
import net.model.Driver;
import net.model.SpareDriver;
@Service("adminservice")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private DriverDao driverDao;
	@Override
	@Transactional
	public void regDriver(Driver driver) {
		// TODO Auto-generated method stub
		adminDao.registerDriver(driver);
	}
	@Override
	public boolean loginadmin(String email, String password) {
		// TODO Auto-generated method stub
		return adminDao.loginAdmin(email, password);
	}
	@Override
	public List<Driver> listDrivers() {
		// TODO Auto-generated method stub
		return driverDao.listDriver();
	}
	@Override
	public List<SpareDriver> regSPareDriver(SpareDriver spareD) {
		// TODO Auto-generated method stub
		return adminDao.regSPareDriver(spareD);
	}
	@Override
	public List<SpareDriver> listSpares() {
		// TODO Auto-generated method stub
		return adminDao.listSpare();
	}
	@Override
	public boolean checkDrivers(int id) {
		// TODO Auto-generated method stub
		return adminDao.checkDriver(id);
	}
	@Override
	public List<Booking> allotSpares(Booking booking) throws IOException, DocumentException {
		// TODO Auto-generated method stub
		 return adminDao.allotSpare(booking);
	}
	@Override
	
	public void updateDriver(Driver driver) {
		// TODO Auto-generated method stub
		adminDao.updateDriver(driver);
		
	}
	@Override
	public Driver getDriver(int id) {
		// TODO Auto-generated method stub
		return adminDao.getDriver(id);
	}
	@Override
	public void removeDriver(int id) {
		// TODO Auto-generated method stub
		adminDao.removeDriver(id);
	}
	@Override
	public SpareDriver getSpareDriver(int id) {
		// TODO Auto-generated method stub
		return adminDao.getSapreDriver(id);
	}
	@Override
	public void updateSpareDriver(SpareDriver spareD) {
		// TODO Auto-generated method stub
		adminDao.updateSpareDriver(spareD);
	}
	@Override
	public void removeSpare(int id) {
		// TODO Auto-generated method stub
		adminDao.removeSpare(id);	}

	

	
}
