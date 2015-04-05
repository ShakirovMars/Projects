package Life;

import java.util.Random;
import java.util.Scanner;

public class OldGeneration {
	public boolean[][] mas;
	public int n;
	public int m;
	public int l = 0;

	public void input() {
		// Filled with an array of
		int b = 0;
		int i;
		int j;
		System.out.println("Enter the number of rows in the field");
		Scanner sc = new Scanner(System.in);
		do {
			if (b > 0) {
				System.out
						.println("Type a number equal to or greater than three");
			}
			n = sc.nextInt();
			b++;

		} while (n < 3);
		System.out.println("Enter the number of columns in the field ");
		b = 0;
		do {

			if (b > 0) {
				System.out
						.println("Type a number equal to or greater than three");
			}
			m = sc.nextInt();
			b++;
		} while (m < 3);
		b = 0;
		mas = new boolean[n][m];

		System.out.println("Specify the number of living cells");
		do {
			if (b > 0) {
				System.out
						.println("Living cells must not be greater than the field");
			}

			l = sc.nextInt();
			b++;
		} while (l > n * m);
		b = 0;
		// Mode is selected arrangement of living cells
		if (l > 0) {
			System.out.println("Select");
			System.out.println("1)Alignment manually");
			System.out.println("2)Alignment of randomly");
			int rejim;
			do {
				if (b > 0) {
					System.out.println("Select the correct mode");
				}

				rejim = sc.nextInt();
				b++;
			} while (rejim != 1 && rejim != 2);
			b = 0;
			int k = l;
			if (rejim == 1) {

				System.out
						.println("Specify the position of living cells, enter the coordinates");

				while (k > 0) {
					System.out.println("Enter the string");
					do {
						if (b > 0) {
							System.out.println("Enter the correct string");
						}
						i = sc.nextInt();
						b++;
					} while (i < 0 || i >= n);
					b = 0;
					System.out.println("Enter the column");
					do {
						if (b > 0) {
							System.out.println("Enter the correct column");
						}
						j = sc.nextInt();
						b++;
					} while (j < 0 || j >= m);
					b = 0;
					mas[i][j] = true;
					k--;
					b = 0;
				}
			} else {
				k = l;
				Random rand = new Random();
				while (k > 0) {
					i = rand.nextInt(n - 1);
					j = rand.nextInt(m - 1);
					mas[i][j] = true;
					k--;
					b = 0;
				}
			}
		}
		sc.close();

	}

	// Concluded in a convenient form

	public void sysoPole() {
		String[][] a = new String[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mas[i][j] == true) {
					a[i][j] = "L";
				} else
					a[i][j] = "*";
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");
			}
		}

	}
}
