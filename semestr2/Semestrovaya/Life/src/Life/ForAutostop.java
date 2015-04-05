package Life;

public class ForAutostop {
	public boolean[][] mas2;

	// Auxiliary array to test matches (automatic stop)
	public void copy(OldGeneration oldGeneration) {
		mas2 = new boolean[oldGeneration.n][oldGeneration.m];
		for (int i = 0; i < oldGeneration.n; i++) {
			for (int j = 0; j < oldGeneration.m; j++) {
				mas2[i][j] = oldGeneration.mas[i][j];

			}
		}
	}
}
