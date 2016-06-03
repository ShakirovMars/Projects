package ru.kpfu.AutoFx.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Auto {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("model")
	private String model;

	@JsonProperty("yearAuto")
	private int yearAuto;

	@JsonProperty("cost")
	private int cost;

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

	public Auto(String model, int yearAuto, int cost, String typeAuto) {
		this.model = model;
		this.yearAuto = yearAuto;
		this.cost = cost;
		this.typeAuto = typeAuto;

	}

}
