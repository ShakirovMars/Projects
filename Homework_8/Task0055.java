package Homework_8;

import java.util.Scanner;

public class Task0055 {
	public static float max(float x, float y) {
		float max = 0;

		if (x <= y) {
			max = y;
		} else
			max = x;

		return max;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		float x = 0;
		float y = 0;
		int n = 0;
		int i = 0;
		float max;
		float l = 0;

		while (n != 3) {
			System.out.println("vvedite " + (i + 1) + " chislo");
			x = sc.nextFloat();
			System.out.println("vvedite " + (i + 2) + " chislo");
			y = sc.nextFloat();
			max = max(x, y);
			i = i + 2;
			n++;
			if (max > l)
				l = max;
		}

		sc.close();

		System.out.println(l);

	}
}
