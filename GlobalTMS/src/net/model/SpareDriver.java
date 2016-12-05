package net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="sparedriver")
public class SpareDriver {

	@Id
	@Column(name="id")
	@NotNull
	private Integer id;
	@NotEmpty(message= "Email must not be blank")
	@Column(name="email")
	private String email;
	@NotEmpty(message= "Name must not be blank")
	@Column(name="name")
	private String name;
	@NotEmpty(message= "Vehicle No must not be blank")
	@Column(name="v_no")
	private String v_no;
	@NotEmpty(message= "Vehicle type must not be blank")
	@Column(name="v_type")
	private String v_type;
	
	@Column(name="mob")
	private Long mob;

	

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

	public String getV_no() {
		return v_no;
	}

	public void setV_no(String v_no) {
		this.v_no = v_no;
	}

	public String getV_type() {
		return v_type;
	}

	public void setV_type(String v_type) {
		this.v_type = v_type;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getMob() {
		return mob;
	}

	public void setMob(Long mob) {
		this.mob = mob;
	}

	

	

	
	
}
