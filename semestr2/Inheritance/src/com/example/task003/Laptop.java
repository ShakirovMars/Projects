package com.example.task003;

public class Laptop extends Computer {
	int batteryCapacity;

	public Laptop(int numberCores, double clockSpeed, String graphicsCard,
			int RAM, int hardDisk, int batteryCapacity) {
		super(graphicsCard, numberCores, clockSpeed, batteryCapacity,
				RAM);
		this.batteryCapacity = batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public void charge(int chargeLevel) {
		if (chargeLevel > batteryCapacity) {
			System.out.println("Eror this can not be");
		} else {
			if (chargeLevel < batteryCapacity) {
				System.out.println("laptop charging");
			} else
				System.out.println("laptop charged");
		}
	}
}