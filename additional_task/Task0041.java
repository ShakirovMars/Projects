package additional_task;

public class Task0041 {
	public static void main(String args[]) {
		int n = 0;

		while (n <= 15) {
			for (int i = 100; n <= 15; i++)
				if (i % 19 == 0) {
					n++;
					System.out.println(i);
				}
		}

	}
}