package com.example.task001;

public class Lamp {
	private int light;
	private boolean condition;

	public void switchOn() {
		if (!condition) {
			condition = true;
			light = 5;
		}
	}

	public void switchOff() {
		if (condition) {
			condition = false;
			light = 0;
		}
	}

	public void increaseLight() {
		if (condition && light != 10) {
			light++;
		}
	}

	public void decreaseLight() {
		if (condition && light != 0) {
			light--;
		}
		if (light == 0) {
			condition = false;
		}
	}

	public int getLight() {
		return light;
	}

	public boolean isCondition() {
		return condition;
	}
}
