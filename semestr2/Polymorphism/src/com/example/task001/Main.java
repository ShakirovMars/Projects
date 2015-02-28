package com.example.task001;

public class Main {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[6];
		vehicles[0] = new Tram();
		vehicles[1] = new Trolley();
		vehicles[2] = new Bus();
		vehicles[3] = new Car();
		vehicles[4] = new Bicycle();
		vehicles[5] = new Motorcycle();
		drive(vehicles);

	}

	private static void drive(Vehicle[] vehicles) {
		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i].drive();
		}

	}

}
