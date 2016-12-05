package net.dao;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import net.model.Booking;

public interface CreateFile {
	public void createfile(Booking booking,boolean yes) throws IOException, DocumentException;
	public void createfileDriver(Booking booking) throws IOException, DocumentException;
}
