package net.service;

import net.model.Booking;

public interface DeskService {
	public boolean loginServiceDesk(String email, String password);
	public void billAmounta(Booking booking);
}
