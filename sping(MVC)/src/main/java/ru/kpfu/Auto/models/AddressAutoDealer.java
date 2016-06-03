package ru.kpfu.Auto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "addressAutoDealer")
public class AddressAutoDealer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "autoDealerId", nullable = false,updatable = false)
	private AutoDealer autoDealerId;

	@Column(name = "x", nullable = false)
	@NotNull
	private double x;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}





	public AutoDealer getAutoDealerId() {
		return autoDealerId;
	}

	public void setAutoDealerId(AutoDealer autoDealerId) {
		this.autoDealerId = autoDealerId;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "y", nullable = false)
	@NotNull
	private double y;

	@Column(name = "address", nullable = false)
	@NotNull
	private String address;

	
	public AddressAutoDealer(){
		
	}
}
