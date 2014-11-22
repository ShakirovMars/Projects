package additional_task;

public class Task0051 {
	public static void main(String args[]) {

		int s = 0;
		int k = 0;
		for (int n = 50; n <= 70; n++) {
			s = 0;
			System.out.print(" symma delitelei " + n + ":");
			for (int i = 1; i <= n; i++) {
				if (n % i == 0) {
					k = i;
					s = s + k;
				}
			}
			System.out.print(s);
			System.out.println();
		}
	}
}