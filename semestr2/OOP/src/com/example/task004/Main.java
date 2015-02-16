package com.example.task004;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("vvedite kolichestvo elementov ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas[] = new int[n];
		System.out.println("vvedite chusla massiva");
		for (int i = 0; i < n; i++)
			mas[i] = sc.nextInt();
		sc.close();
		Vector massiv = new Vector(mas);
		massiv.cleanMas();
		// *massiv.addMasIndex(3,9);
		// *massiv.addMas(4);
		// *massiv.delMasIndex(2);
		massiv.sysoMas();

	}
}
