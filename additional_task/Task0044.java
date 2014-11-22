package additional_task;

import java.util.Scanner;

public class Task0044 {
	public static void main(String args[]) {
		int n;
		double s = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("vvedite kolichestvo chisel n= ");
		n = sc.nextInt();
		double mas1[] = new double[n];
		System.out.println("vvedite chisla");

		for (int i = 0; i < n; i++)
			mas1[i] = sc.nextDouble();

		sc.close();
		for (int i = 0; i < n; i++)
			if (mas1[i] > 10.75)
				s = s + mas1[i];

		System.out.println("summa=" + s);
	}

}
