package net.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="driver")
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="driver_id")
	private int driver_id;
	@Column(name="d_name")
	@NotEmpty(message= "Name Should not be empty")
	private String d_name;
	@Column(name="email")
	@NotEmpty(message= "Email Should not be empty")
	private String email;
	@Column(name="vehicle_no")
	@NotEmpty(message= "Vehicle should not be empty")
	private String vehicle_no;
	@Column(name="vehicle_type")
	@NotEmpty(message= "Vehicle type Should not be empty")
	private String vehicle_type;
	@Column(name="s_date")
	private Date s_date;
	@Column(name="e_date")
	private Date e_date;
	
	/*@OneToMany(cascade=CascadeType.ALL, mappedBy="driver")
	private Set<Booking> bookings;
	public Set<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}*/
	

	
	public String getD_name() {
		return d_name;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

}
