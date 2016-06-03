package ru.kpfu.RestService.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "auto")
public class Auto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    @JsonProperty("id")
	private Integer id;

	@Column(name = "model", nullable = false)
    @JsonProperty("model")
	private String model;

	

	@Column(name = "yearAuto", nullable = false)
	 @JsonProperty("yearAuto")
	private int yearAuto;

	
	
	@Column(name = "cost", nullable = false)
	@JsonProperty("cost")
	private int cost;


	@Column(name = "typeAuto", nullable = false)
	@JsonProperty("typeAuto")
	private String typeAuto;
	
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



	public Auto() {

	}
	
	public Auto(String model,int yearAuto,int cost,String typeAuto){
		this.model=model;
		this.yearAuto=yearAuto;
		this.cost=cost;
		this.typeAuto=typeAuto;
		
	}
	
	
}

