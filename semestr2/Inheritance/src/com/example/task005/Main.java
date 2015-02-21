package com.example.task005;

public class Main {
	public static void main(String[] args) {
		Pet[] pets = new Pet[3];
		pets[0] = new Cat();
		pets[1] = new Dog();
		pets[2] = new Fish();
		voice(pets);
	}

	private static void voice(Pet[] pets) {
		for (int i = 0; i < pets.length; i++) {
			pets[i].voice();
		}
	}

}
