package net.service;

import net.dao.ServiceDao;
import net.model.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deskService")
public class DeskServiceImpl implements DeskService{
	
	@Autowired
	private ServiceDao serviceDao;
	@Override
	public boolean loginServiceDesk(String email, String password) {
		// TODO Auto-generated method stub
		return serviceDao.loginService(email, password);
	}
	@Override
	public void billAmounta(Booking booking) {
		// TODO Auto-generated method stub
		 serviceDao.billAmount(booking);
	}

}
