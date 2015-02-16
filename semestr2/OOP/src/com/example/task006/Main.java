package com.example.task006;

public class Main {
	public static void main(String[] args) {
		Address address = new Address("Russia");
		System.out.println(address.getCountry());
		address.setRegion("Volga");
		System.out.println(address.getRegion());
		address.setCity("Kazan");
		System.out.println(address.getCity());
		address.setStreet("Bauman");
		System.out.println(address.getStreet());
		address.setHouse(12);
		System.out.println(address.getHouse());
		address.setIndex(4544);
		System.out.println(address.getIndex());
		System.out.println();
		Address address1 = new Address("Russia", "Volga", "Kazan", "Bauman", 18);
		System.out.println(address1.house);

	}
}
