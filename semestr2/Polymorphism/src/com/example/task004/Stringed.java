package com.example.task004;

public class Stringed extends Instrument {

	@Override
	public void play() {
		System.out.println("Stringed  playing");

	}

	@Override
	public void getName() {
		System.out.println("Stringed ");

	}

	@Override
	public void adjust() {
		System.out.println("Stringed  customizing");

	}

}
