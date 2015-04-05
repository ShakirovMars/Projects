package Life;

public class Rules {
	boolean repeat = false;

	// Method of counting the number of living cells
	public void check(OldGeneration oldGeneration, NewGeneration newGeneration) {
		int s = 0;

		for (int i = 0; i < oldGeneration.n; i++) {
			for (int j = 0; j < oldGeneration.m; j++) {
				if ((i - 1 != -1) && (i + 1 != oldGeneration.n)
						&& (j - 1 != -1) && (j + 1 != oldGeneration.m)) {
					if (oldGeneration.mas[i + 1][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i][j - 1] == true) {
						s++;
					}

				}
				if ((j - 1 == -1) && (i + 1 != oldGeneration.n)
						&& (i - 1 != -1) && (j + 1 != oldGeneration.m)) {
					if (oldGeneration.mas[i][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j + 1] == true) {
						s++;
					}

				}
				if ((j + 1 == oldGeneration.m) && (i + 1 != oldGeneration.n)
						&& (i - 1 != -1) && (j - 1 != -1)) {
					if (oldGeneration.mas[i][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j - 1] == true) {
						s++;
					}

				}
				if ((i - 1 == -1) && (j - 1 == -1)) {
					if (oldGeneration.mas[i][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j + 1] == true) {
						s++;
					}

				}
				if ((i + 1 == oldGeneration.n) && (j - 1 == -1)) {
					if (oldGeneration.mas[i - 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i][j + 1] == true) {
						s++;
					}

				}
				if ((i - 1 == -1) && (j + 1 == oldGeneration.m)) {
					if (oldGeneration.mas[i][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j] == true) {
						s++;
					}

				}
				if ((i + 1 == oldGeneration.n) && (j + 1 == oldGeneration.m)) {
					if (oldGeneration.mas[i][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j - 1] == true) {
						s++;
					}

				}
				if ((i + 1 == oldGeneration.n) && (j + 1 != oldGeneration.m)
						&& (j - 1 != -1) && (i - 1 != -1)) {
					if (oldGeneration.mas[i][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i - 1][j - 1] == true) {
						s++;
					}

				}
				if ((i + 1 != oldGeneration.n) && (j + 1 != oldGeneration.m)
						&& (j - 1 != -1) && (i - 1 == -1)) {
					if (oldGeneration.mas[i][j - 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j + 1] == true) {
						s++;
					}
					if (oldGeneration.mas[i + 1][j - 1] == true) {
						s++;
					}
				}
				// Check cell viability
				if (oldGeneration.mas[i][j] == false) {
					if (s == 3) {
						newGeneration.mas1[i][j] = true;

					}
				} else if (s == 2 || s == 3) {
					newGeneration.mas1[i][j] = true;

				}

				s = 0;
			}

		}
	}

	// Update generation
	public void aNewGeneration(OldGeneration oldGeneration,
			NewGeneration newGeneration) {
		int p = 0;
		for (int i = 0; i < oldGeneration.n; i++) {
			for (int j = 0; j < oldGeneration.m; j++) {
				if (newGeneration.mas1[i][j] == true) {
					p++;
				}
				oldGeneration.mas[i][j] = newGeneration.mas1[i][j];
			}
		}
		// Updating the number of live cells and the array further purification
		oldGeneration.l = p;
		newGeneration.additionalArray(oldGeneration);
	}

	// Check repetition generation
	public void autostop(OldGeneration oldGeneration,
			NewGeneration newGeneration, ForAutostop forAutostop) {
		int t = 0;

		for (int i = 0; i < oldGeneration.n; i++) {
			for (int j = 0; j < oldGeneration.m; j++) {
				if (forAutostop.mas2[i][j] == oldGeneration.mas[i][j]) {

					t++;
				}
			}
		}

		if (t == oldGeneration.n * oldGeneration.m) {
			repeat = true;
		}
		// Preservation of a new generation
		forAutostop.copy(oldGeneration);
		t = 0;
	}
}
