package com.example.task004;

import com.example.task001.Vehicle;

public class Main {
	public static void main(String[] args) {
		Instrument[] instruments = new Instrument[5];
		instruments[0] = new Wind();
		instruments[1] = new Brasswind();
		instruments[2] = new Stringed();
		instruments[3] = new Woodwind();
		instruments[4] = new Percussion();
		play(instruments);
		getName(instruments);
		adjust(instruments);

	}

	private static void play(Instrument[] instruments) {
		for (int i = 0; i < instruments.length; i++) {
			instruments[i].play();

		}
	}

	private static void adjust(Instrument[] instruments) {
		for (int i = 0; i < instruments.length; i++) {
			instruments[i].getName();

		}
	}

	private static void getName(Instrument[] instruments) {
		for (int i = 0; i < instruments.length; i++) {
			instruments[i].adjust();

		}
	}

}