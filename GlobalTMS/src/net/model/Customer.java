package net.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer11")
public class Customer {
	
	@Id
	@Column(name="email")
	@NotEmpty(message= "Email Should not be empty")
	@NotNull(message= "Email Should not be null")
	private String email;
	
	@NotEmpty(message= "Name must not be blank")
	@Column (name="name")
	private String name;
	@Column (name="password")
	@NotEmpty(message = "Password must not be blank man.")
	@Size(min = 1, max = 10, message = "Password must between 1 to 10 Characters.")
	private String password;
	@Column (name="address")
	private String address;
	@Column (name="mob")
	@NumberFormat(style=Style.NUMBER)
	private long mob;
	
	public long getMob() {
		return mob;
	}


	public void setMob(long mob) {
		this.mob = mob;
	}


	/*@OneToMany(mappedBy="customer")
	private Set<Booking> bookings;
*/
		public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}




/*
	public Set<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

*/

	
}
