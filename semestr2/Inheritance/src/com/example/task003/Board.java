package com.example.task003;

public class Board extends Laptop {
	public String OS;
  public Board(int numberCores, double clockSpeed, String graphicsCard,
			int RAM, int hardDisk, int batteryCapacity,String OS) {
	  
		super(numberCores, clockSpeed, graphicsCard, RAM, hardDisk, batteryCapacity);
		this.OS=OS;
	}
  public void setOS(String OS) {
		this.OS = OS;
	}

	public String getOS() {
		return OS;
	}




}
