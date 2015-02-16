package com.example.task006;

public class Address {
	public String country;
	public String region;
	public String city;
	public String street;
	public int house;
	public int index;

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	public void setHouse(int house) {
		this.house = house;
	}

	public int getHouse() {
		return house;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	 public Address (String country){
		 this.country=country;
	 }
	 public Address (String country,String region){
		 this.country=country;
		 this.region=region;
	 }
	 public Address (String country,String region,String city){
		 this.country=country;
		 this.region=region;
	     this.city=city;
	 }
	 public Address (String country,String region,String city,String street){
		 this.country=country;
		 this.region=region;
	     this.city=city;
	     this.street=street;
	 }
	 public Address (String country,String region,String city,String street,int house){
		 this.country=country;
		 this.region=region;
	     this.city=city;
	     this.street=street;
	     this.house=house;
	   } 
	 public Address (int index){
		 this.index=index;
	   } 
	 
	 
	 
}