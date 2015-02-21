package com.example.task001;

import java.util.Scanner;

public class Array {
	public int constant[];
	public String variable[];

	public void createConst(int n) {
		Scanner sc = new Scanner(System.in);
		int constant[] = new int[n];
		System.out.println("vvedite constanti");
		for (int i = 0; i < n; i++)
			constant[i] = sc.nextInt();
		this.constant = constant;
	}

	public void createVar(int n) {

		String variable[] = new String[n - 1];
		for (int i = 0; i < n - 1; i++)
			variable[i] = "x" + i;
		this.variable = variable;

	}

}
