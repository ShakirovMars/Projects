package ru.kpfu.Auto.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "autoDealer")
public class AutoDealer {

	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "id", unique = true, nullable = false)
	  private Integer id;
	  
	  @OneToMany(mappedBy = "autoDealer", fetch = FetchType.LAZY)
	  private List<Auto> auto = new ArrayList<Auto>();
	  
	  
	  @Column(name = "name" ,nullable = false)
	  @NotNull
	  @Size(min = 1, max = 255)
	  private String name;
	  

	  @OneToMany(fetch = FetchType.EAGER,mappedBy = "autoDealerId")
	  private List<AddressAutoDealer> addressAutoDealer = new ArrayList<AddressAutoDealer>();





	public List<AddressAutoDealer> getAddressAutoDealer() {
		return addressAutoDealer;
	}


	public void setAddressAutoDealer(List<AddressAutoDealer> addressAutoDealer) {
		this.addressAutoDealer = addressAutoDealer;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<Auto> getAuto() {
		return auto;
	}


	public void setAuto(List<Auto> auto) {
		this.auto = auto;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public AutoDealer(){
		
		
	}
	
}
