package additional_task;

public class Task0048 {
	public static void main(String args[]) {

		int s = 0;

		for (int n = 1; n <= 300; n++) {
			s = 0;
			for (int i = 1; i <= n; i++) {

				if (n % i == 0) {
					s++;
				}
			}

			if (s == 5)

				System.out.println("5 delitelei: " + n);

		}

	}
}