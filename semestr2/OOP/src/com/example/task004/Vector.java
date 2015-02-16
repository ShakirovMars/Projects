package com.example.task004;

public class Vector {

	private int[] mas;

	public void setMas(int mas[]) {
		this.mas = mas;
	}

	public int[] getMas() {
		return mas;
	}

	public Vector(int[] mas) {
		this.mas = mas;

	}

	public void cleanMas() {
		int mas1[] = new int[mas.length];
		mas = mas1;
	}

	public void addMas(int element) {
		int mas1[] = new int[mas.length + 1];

		for (int i = 0; i < mas.length; i++) {
			mas1[i] = mas[i];
		}
		mas1[mas1.length - 1] = element;

		mas = mas1;
	}

	public void addMasIndex(int index, int element) {
		if (index > mas.length || index < 0) {
			System.out.println("error");
		} else {
			int[] mas1 = new int[mas.length + 1];
			for (int i = 0; i < mas.length; i++) {
				if (i < index) {
					mas1[i] = mas[i];
				} else {
					mas1[i + 1] = mas[i];
				}
			}
			mas1[index] = element;
			mas = mas1;
		}
	}

	public void delMasIndex(int index) {
		if (index >= mas.length || index < 0) {
			System.out.println("error");
		} else {
			int[] mas1 = new int[mas.length - 1];
			for (int i = 0; i < mas.length; i++) {
				if (i < index) {
					mas1[i] = mas[i];
				}
				if ((i > index) & (i != index)) {
					mas1[i - 1] = mas[i];
				}
			}

			mas = mas1;
		}
	}

	public void sysoMas() {
		for (int i = 0; i < mas.length; i++) {
			System.out.println(mas[i]);
		}
	}
}
