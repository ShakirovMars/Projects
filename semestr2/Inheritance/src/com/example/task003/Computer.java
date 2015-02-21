package com.example.task003;

public class Computer {
	public int numberCores;
	public double clockSpeed;
	public String graphicsCard;
	public int RAM;
	public int hardDisk;

	public Computer(String graphicsCard,int numberCores, double clockSpeed,
			int RAM, int hardDisk) {

		this.numberCores = numberCores;
		this.clockSpeed = clockSpeed;
		this.graphicsCard = graphicsCard;
		this.RAM = RAM;
		this.hardDisk = hardDisk;
	}

	public int getNumberCores() {
		return numberCores;
	}

	public void setNumberCores(int numberCores) {
		this.numberCores = numberCores;
	}

	public double getClockSpeed() {
		return clockSpeed;
	}

	public void setClockSpeed(double clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}

	public String getGraphicsCard() {
		return graphicsCard;
	}

	public void setRAM(int RAM) {
		this.RAM = RAM;
	}

	public int getRAM() {
		return RAM;
	}

	public void setHardDisk(int hardDisk) {
		this.hardDisk = hardDisk;
	}

	public int getHardDisk() {
		return hardDisk;
	}

	public void TurnOn() {
		System.out.println("The computer is on");
	}

	public void TurnOff() {
		System.out.println("The computer is off");
	}
}
