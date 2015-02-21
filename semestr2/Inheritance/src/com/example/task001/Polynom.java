package com.example.task001;

public class Polynom extends Array {
	public void createPolynom(int n) {
		super.createConst(n);
		super.createVar(n);
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				System.out.print(constant[i]);
			} else {
				if (constant[i] >= 0) {
					System.out.print("+" + constant[i] + "*" + variable[i - 1]);
				} else
					System.out.print(constant[i] + "*" + variable[i - 1]);

			}

		}
	}
}