package ClassWork;

import java.util.Scanner;

public class kontr_4 {
	private static Scanner input;

	public static void main(String[] args) {
		int t = 0;

		int p;
		int k;
		int l;
		int mas1[] = new int[4];
		int mas2[] = new int[4];
		int mas3[] = new int[4];
		k = (int) (Math.random() * 9999) + 1;
		System.out.println("chislo compitera: " + k);

		input = new Scanner(System.in);

		do {
			p = k;
			System.out.print("vvodite chislo: ");
			l = input.nextInt();

			t = 0;
			if (l == k) {
				System.out.println("vi otgadali");
				System.out.println("moe chislo bilo: " + k);
			} else if (l < 1 || l >= 10000) {

				System.out.println("ne v diapazone");
			} else {

				for (int i = 0; i < 4; i++) {
					mas1[i] = l % 10;
					mas2[i] = p % 10;

					p = p / 10;
					l = l / 10;
				}
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (mas1[i] == mas2[j]) {

							mas3[i] = mas1[i];

							mas2[j] = -1;
							System.out.println(mas3[i] + " sovpala");

							t++;
						}

					}
				}
				if (t == 0)
					System.out.println("net sovpadeni");
			}
		} while (l != k);

	}
}
