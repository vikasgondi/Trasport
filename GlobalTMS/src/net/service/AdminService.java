package net.service;

import java.io.IOException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import net.model.Booking;
import net.model.Driver;
import net.model.SpareDriver;

public interface AdminService {
	public void regDriver(Driver driver);
	public boolean loginadmin(String email, String password);
	public List<Driver> listDrivers();
	public List<SpareDriver> regSPareDriver(SpareDriver spareD);
	public List<SpareDriver> listSpares();
	public boolean checkDrivers(int id);
	public List<Booking> allotSpares(Booking booking) throws IOException, DocumentException;
	public void updateDriver(Driver driver);
	public Driver getDriver(int id);
	public void removeDriver(int id);
	public SpareDriver getSpareDriver(int id);
	public void updateSpareDriver(SpareDriver spareD);
	public void removeSpare(int id);
}
