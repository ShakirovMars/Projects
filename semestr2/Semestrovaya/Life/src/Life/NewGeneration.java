package Life;

public class NewGeneration {
	public boolean[][] mas1;
//Auxiliary array for the new generation
	public void additionalArray(OldGeneration oldGeneration) {
		mas1 = new boolean[oldGeneration.n][oldGeneration.m];
		for (int i = 0; i < oldGeneration.n; i++) {
			for (int j = 0; j < oldGeneration.m; j++) {
				mas1[i][j] = false;

			}
		}
	}

}
