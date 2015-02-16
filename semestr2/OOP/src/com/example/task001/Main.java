package com.example.task001;


public class Main {
	public static void main(String args[]) {
		Lamp lamp = new Lamp();
		lamp.switchOn();
		System.out.println(lamp.isCondition());
		System.out.println(lamp.getLight());
		lamp.increaseLight();
		System.out.println(lamp.getLight());
		lamp.decreaseLight();
		System.out.println(lamp.getLight());
		lamp.increaseLight();
		lamp.increaseLight();
		lamp.increaseLight();
		lamp.increaseLight();
		lamp.increaseLight();
		System.out.println(lamp.getLight());
		lamp.increaseLight();
		System.out.println(lamp.getLight());
		lamp.switchOff();
		System.out.println(lamp.getLight());
		System.out.println(lamp.isCondition());
	}
}
