package Game;

public class Pole {
	public static void pole(int n, int m, boolean motion, Player player) {
		String floor[][] = new String[n][m];
		if (motion == false) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if ((i == 0) && (j == 0)) {
						floor[i][j] = "Í";
					} else if ((i == 3) && (j == 3)) {
						floor[i][j] = "Ï";
					} else
						floor[i][j] = "o";
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if ((i == player.getI()) && (j == player.getJ())) {
						floor[i][j] = "*";

					} else if ((i == 0) && (j == 0)) {
						floor[i][j] = "Í";
					} else if ((i == 3) && (j == 3)) {
						floor[i][j] = "Ï";
					} else
						floor[i][j] = "o";
				}
			}

		}

		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int j = 0; j < m; j++) {
				System.out.print(floor[i][j] + " ");
			}
		}
		System.out.println();
	}

}
