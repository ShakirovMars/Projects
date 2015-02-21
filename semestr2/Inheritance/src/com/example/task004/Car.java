package com.example.task004;

public class Car extends Vehicle {
	public boolean trunk;

	public boolean getTrunk() {
		return trunk;
	}

	public void setTrunk(boolean trunk) {
		this.trunk = trunk;
	}

	public Car(boolean trunk) {
		this.trunk = trunk;
	}

	public void presenceTrunk() {
		if (trunk == true) {
			System.out.println("Est baganik");
		} else
			System.out.println("Net baganika ");
	}
}
