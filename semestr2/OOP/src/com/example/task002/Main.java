package com.example.task002;

public class Main {

	public static void main(String[] args) {
		Man man = new Man("Mark");
		System.out.println(man.getName());
		man.setAge(23);
		System.out.println(man.getAge());
		man.setGender('m');
		System.out.println(man.getGender());
		man.setWeight(60);
		System.out.println(man.getWeight());
	}

}
