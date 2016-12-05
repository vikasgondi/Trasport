package net.dao;

import net.model.Booking;

public interface ServiceDao {
	public boolean loginService(String email, String password);
	public void billAmount(Booking booking);
}
