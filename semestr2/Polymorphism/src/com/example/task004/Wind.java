package com.example.task004;

public class Wind extends Instrument {

	@Override
	public void play() {
		System.out.println("Wind playing");

	}

	@Override
	public void getName() {
		System.out.println("Wind ");
	}

	@Override
	public void adjust() {
		System.out.println("Wind customizing");

	}

}
