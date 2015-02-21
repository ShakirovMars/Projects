package com.example.task001;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		System.out.println("vvedite kolichestvo constant ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Polynom polynom = new Polynom();
        polynom.createPolynom(n);

	}
}