package Homework_9;

import java.util.Scanner;

public class Tsak0063 {

	static int m[];
	static int max = 0;

	public static int ind_max(int k) {
		int w;
		if (k > 0) {
			w = ind_max(k - 1);
			if (m[k] < m[w])
				max = w;
			else
				max = k;
		} else
			max = 0;
		return max;
	}

	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.println("vvedite kolichestvo elementov massiva ");
		int n = sc.nextInt();
		m = new int[n];
		System.out.println("vvedite chisla masssiva");
		for (int i = 0; i < n; i++)
			m[i] = sc.nextInt();

		System.out.println("MAX=" + m[ind_max(m.length - 1)]);
		sc.close();

	}

}
