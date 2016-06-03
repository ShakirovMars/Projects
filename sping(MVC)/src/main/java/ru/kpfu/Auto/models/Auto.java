package ru.kpfu.Auto.models;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;



@Entity
@Table(name = "auto")
public class Auto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@NotBlank
	@Size(max = 25)
	@Column(name = "model", nullable = false)
	private String model;

	
	@NotNull
	@Range(min = 1888, max = 2016)
	@Column(name = "yearAuto", nullable = false)
	private int yearAuto;

	
	@NotNull
	@Column(name = "cost", nullable = false)
	private int cost;

	@NotBlank
	@Size(max = 30)
	@Column(name = "typeAuto", nullable = false)
	private String typeAuto;

	@NotBlank
	@Size(max = 30)
	@Column(name = "mark", nullable = false)
	private String mark;

	@NotBlank
	@Size(max = 30)
	@Column(name = "equipment", nullable = false)
	private String equipment;

	@NotBlank
	@Size(max = 30)
	@Column(name = "transmission", nullable = false)
	private String transmission;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "autoDealer", nullable = false)
	private AutoDealer autoDealer;

	
	@Size(max =100)
	@Column(name="description")
	private String description;
	
	
	  @ManyToOne(optional = false,fetch = FetchType.LAZY,cascade = { CascadeType.MERGE })
	  @JoinColumn(name = "userId", nullable = false)
	  private User user;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Auto() {

	}
	

	public AutoDealer getAutoDealer() {
		return autoDealer;
	}

	public void setAutoDealer(AutoDealer autoDealer) {
		this.autoDealer = autoDealer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getTypeAuto() {
		return typeAuto;
	}

	public void setTypeAuto(String typeAuto) {
		this.typeAuto = typeAuto;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearAuto() {
		return yearAuto;
	}

	public void setYearAuto(int yearAuto) {
		this.yearAuto = yearAuto;
	}

}
