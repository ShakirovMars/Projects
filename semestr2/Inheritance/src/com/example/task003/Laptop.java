package com.example.task003;

public class Laptop extends Computer {
	int batteryCapacity;
	public double diagonal;
	public String resolution;
	public double width;
	public double height;

	public Laptop(int numberCores, double clockSpeed, String graphicsCard,
			int RAM, int hardDisk, int batteryCapacity, 
			String resolution, double width, double height) {
		super(graphicsCard, numberCores, clockSpeed, RAM,hardDisk);
		this.batteryCapacity = batteryCapacity;
		this.resolution = resolution;
		this.width = width;
		this.height = height;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public double getDiagonal() {
		return Math.sqrt(width * width + height * height);
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
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