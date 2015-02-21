package com.example.task004;

public class Main {
	public static void main(String[] args) {
		/*
		 * Vehicle[] vehicles = new Vehicle[3]; vehicles[0] = new Bus(21);
		 * vehicles[1] = new Truck(12); vehicles[2] = new Car(true);
		 * start(vehicles); stop(vehicles);
		 * 
		 * 
		 * private static void stop(Vehicle[] vehicles) { for (int i = 0; i <
		 * vehicles.length; i++) { vehicles[i].start(); } }
		 * 
		 * private static void start(Vehicle[] vehicles) { for (int i = 0; i <
		 * vehicles.length; i++) { vehicles[i].stop(); } }
		 */
		Car car = new Car(false);
		// car.presenceTrunk();
		Bus bus = new Bus(110,12 );
		/*bus.setCapacity(115);
		System.out.println(bus.capacity);
		System.out.println(bus.were);
		bus.peopleLogged(1);
		System.out.println(bus.were);*/
        Truck truck=new Truck(500,100);
		truck.setTonnage(3000);
        System.out.println(truck.tonnage);
        System.out.println(truck.were);
        truck.postLoads(120);
        System.out.println(truck.were);
	}
}