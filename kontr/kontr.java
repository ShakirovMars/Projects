package ClassWork;

import java.util.Scanner;

public class kontr {
	public static void main(String[] args) {
		int l;
		System.out.println("¬ведите число элементов массива ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mas1[] = new int[n];
		System.out.println("¬ведите числа массива");

		for (int i = 0; i < n; i++) {
			mas1[i] = sc.nextInt();
		}
		System.out.println("¬ведите число ");
		int m = sc.nextInt();
		sc.close();
		n=n-1;
		if (mas1[n] == m) {
			System.out.println(n);
		} else
			while (mas1[n] != m) {
			if (n % 2 == 0) {
					n = n / 2;

				} else
					n = n + 1 / 2-1;
				if (mas1[n] == m) {
					System.out.println(n);
				} else {

					if (mas1[n] > m) {
						n = n * 2 - 3;
					} else {
						n = n * 4+1;
					}

				}

			}
		}
	
}