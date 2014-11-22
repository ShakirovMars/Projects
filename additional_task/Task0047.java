package additional_task;

public class Task0047 {
	public static void main(String args[]) {
		int k;

		for (int n = 120; n <= 140; n++) {
			System.out.print(" deliteli " + n + ":");
			for (int i = 1; i <= n; i++) {

				if (n % i == 0) {
					k = i;

					System.out.print(" " + k);

				}
			}
			System.out.println();
		}

	}
}