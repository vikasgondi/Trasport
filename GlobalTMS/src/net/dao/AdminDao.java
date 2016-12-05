package net.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Transaction;

import com.itextpdf.text.DocumentException;

import net.model.Booking;
import net.model.Driver;
import net.model.SpareDriver;

public interface AdminDao {

	public void registerDriver(Driver driver);
	public boolean loginAdmin(String email, String password);
	public List<SpareDriver> regSPareDriver(SpareDriver spareD);
	public List<SpareDriver> listSpare();
	public boolean checkDriver(int id);
	public List<Booking> allotSpare(Booking booking) throws IOException, DocumentException;
	public void updateDriver(Driver driver);
	public Driver getDriver(int id);
	public void removeDriver(int id);
	public SpareDriver getSapreDriver(int id);
	public void updateSpareDriver(SpareDriver spareD);
	public void removeSpare(int id);
} 
