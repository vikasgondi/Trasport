package net.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.model.Booking;
@Repository("createfile")
public class CreateFileImpl implements CreateFile{

	@Override
	public void createfile(Booking booking, boolean yes) throws IOException, DocumentException {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Invoice1");
        if(!dir.exists()){
            dir.mkdir();
        }
		
			File file = new File(dir,booking.getB_id()+".pdf");
			

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
		
			
			
			FileOutputStream fout = new FileOutputStream(file);
			Document doc= new Document();
			PdfWriter.getInstance(doc, fout);
			PdfPTable table=new PdfPTable(2);
			 table.setWidthPercentage(100);
		        table.getDefaultCell().setUseAscender(true);
		        table.getDefaultCell().setUseDescender(true);
			 Font font = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, GrayColor.BLACK);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			//table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
			table.setSpacingBefore(30.0f);
			table.addCell("Customer Name");
			table.addCell(booking.getCustomer().getName());
			table.addCell("Customer Email");
			table.addCell(booking.getCustomer().getEmail());
			table.addCell("Customer Mob");
			table.addCell(Long.toString(booking.getCustomer().getMob()));
			table.addCell("Customer Address");
			table.addCell(booking.getCustomer().getAddress());
			table.addCell("Booking Id");
			table.addCell(Long.toString(booking.getB_id()));
			table.addCell("Vehicle Type");
			table.addCell(booking.getV_type());
			table.addCell("Start Date");
			table.addCell(booking.getS_date().toString());
			table.addCell("End Date");
			table.addCell(booking.getE_date().toString());
			table.addCell("Payed Amount");
			table.addCell(Double.toString(booking.getE_amount()));	
			if(yes){
				table.addCell("Driver ID");
				table.addCell(Integer.toString(booking.getDriver().getDriver_id()) );	
				table.addCell("Driver Name");
				table.addCell(booking.getDriver().getD_name());	
				table.addCell("Vehicle No");
				table.addCell(booking.getDriver().getVehicle_no());
				table.addCell("Vehicle No");
				table.addCell(booking.getDriver().getVehicle_no());
			}
			doc.open();
			doc.add(new Paragraph("Hi.... Here is your invoice for booking  "));
			//doc.add(new Paragraph(booking.toString()));
			doc.add(table);
			/*ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeChars(Content);
			//oos.writeChars(booking.getCustomer().getName());
			//oos.writeObject(booking);
			oos.close();*/
			doc.close();
			fout.close();
	}

	@Override
	public void createfileDriver(Booking booking) throws IOException,
			DocumentException {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Driver");
        if(!dir.exists()){
            dir.mkdir();
        }
		
			File file = new File(dir,booking.getB_id()+".pdf");
			

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
		
			
			
			FileOutputStream fout = new FileOutputStream(file);
			Document doc= new Document();
			PdfWriter.getInstance(doc, fout);
			PdfPTable table=new PdfPTable(2);
			 table.setWidthPercentage(100);
		        table.getDefaultCell().setUseAscender(true);
		        table.getDefaultCell().setUseDescender(true);
			 Font font = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, GrayColor.BLACK);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			//table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
			table.setSpacingBefore(30.0f);
			table.addCell("Customer Name");
			table.addCell(booking.getCustomer().getName());
			table.addCell("Customer Email");
			table.addCell(booking.getCustomer().getEmail());
			table.addCell("Customer Mob");
			table.addCell(Long.toString(booking.getCustomer().getMob()));
			table.addCell("Customer Address");
			table.addCell(booking.getCustomer().getAddress());
			table.addCell("Booking Id");
			table.addCell(Long.toString(booking.getB_id()));
			table.addCell("Vehicle Type");
			table.addCell(booking.getV_type());
			table.addCell("Start Date");
			table.addCell(booking.getS_date().toString());
			table.addCell("End Date");
			table.addCell(booking.getE_date().toString());
			table.addCell("Payed Amount");
			table.addCell(Double.toString(booking.getE_amount()));	
			
				table.addCell("Driver ID");
				table.addCell(Integer.toString(booking.getSpareD().getId()) );	
				table.addCell("Driver Name");
				table.addCell(booking.getSpareD().getName());	
				table.addCell("Vehicle No");
				table.addCell(booking.getSpareD().getV_no());
				table.addCell("Driver No");
				table.addCell(Long.toBinaryString(booking.getSpareD().getMob()));
		
			doc.open();
			doc.add(new Paragraph("Hi.... Here is your driver details  "));
			//doc.add(new Paragraph(booking.toString()));
			doc.add(table);
			/*ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeChars(Content);
			//oos.writeChars(booking.getCustomer().getName());
			//oos.writeObject(booking);
			oos.close();*/
			doc.close();
			fout.close();
	}
	
	

}
