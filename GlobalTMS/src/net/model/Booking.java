package net.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="booking")
public class Booking implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	public String toString() {
		return String
				.format("Booking [b_id=%s, v_type=%s, s_date=%s, e_date=%s, p_location=%s, c_id=%s, e_amount=%s, customer=%s]",
						b_id, v_type, s_date, e_date, p_location, c_id,
						e_amount, customer);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="b_id")
	@NotNull
	private long b_id;
	
	
	@Column(name="v_type")
	@NotNull
	private String v_type; 
	
	@Column(name="s_date")
	@NotNull
	private Date s_date;
	
	
	

	

	@Column(name="e_date")
	@NotNull
	private Date e_date;
	
	@Column(name="p_location")
	@NotNull
	@NotEmpty(message= "Pick up location  Should not be empty")
	private String p_location;
	@Column(name="c_id")
	private String c_id;
	
	@Column(name="Estimated_amount")
	private double e_amount;
	@Column(name="s_kms")

	private  Integer s_kms;
	@Column(name="e_kms")
	private Integer e_kms;
	@Column(name="t_amount")
	private Integer t_amount;
	@Column(name="Status")
	private String status;
	
	public long getB_id() {
		return b_id;
	}

	public void setB_id(long b_id) {
		this.b_id = b_id;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getS_kms() {
		return s_kms;
	}

	public void setS_kms(Integer s_kms) {
		this.s_kms = s_kms;
	}

	public Integer getE_kms() {
		return e_kms;
	}

	public void setE_kms(Integer e_kms) {
		this.e_kms = e_kms;
	}

	
	public Integer getT_amount() {
		return t_amount;
	}

	public void setT_amount(Integer t_amount) {
		this.t_amount = t_amount;
	}

	public double getE_amount() {
		return e_amount;
	}

	public void setE_amount(double e_amount) {
		
		/*int diffInDays = (int)( (this.e_date.getTime() - this.s_date.getTime()) 
                / (1000 * 60 * 60 * 24) );
		*/
		this.e_amount = e_amount;
	}
	
	public SpareDriver getSpareD() {
		return spareD;
	}

	public void setSpareD(SpareDriver spareD) {
		this.spareD = spareD;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToOne(cascade=CascadeType.ALL)
	private SpareDriver spareD;
	
	@ManyToOne
	@JoinColumn(name="email")
	private Customer customer;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	

	

	

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	

	public String getV_type() {
		return v_type;
	}

	public void setV_type(String v_type) {
		this.v_type = v_type;
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

	public String getP_location() {
		return p_location;
	}

	public void setP_location(String p_location) {
		this.p_location = p_location;
	}
	public double calculate(Date start, Date end,int a)
	{
		//DateFormat formatter1;
	//	formatter1 = new SimpleDateFormat("DD/mm/yyyy");
		//System.out.println(vtype);
		
		int diffInDays = (int)( (end.getTime() - start.getTime()) 
                / (1000 * 60 * 60 * 24) );
		System.out.println(diffInDays);
		
		
		int hours= diffInDays*8;
		int kms= hours*90;
		double temp= kms*a;
		return temp;
	}
	

}
