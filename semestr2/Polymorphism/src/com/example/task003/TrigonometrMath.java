package com.example.task003;

public class TrigonometrMath {

	public static double Sin(double x) {
		double sin = x;

		for (int n = 3; n <= 27; n = n + 4) {

			sin = sin - (Stepen.Pow(n, x) / Fact.factorial(n));

			sin = sin + (Stepen.Pow(n + 2, x) / Fact.factorial(n + 2));

		}
		return sin;
	}

	public static double Cos(double x) {
		double cos = 1;

		for (int n = 2; n <= 26; n = n + 4) {
			cos = cos - (Stepen.Pow(n, x) / Fact.factorial(n));
			cos = cos + (Stepen.Pow(n + 2, x) / Fact.factorial(n + 2));
		}

		return cos;
	}

	public static double E(double x) {
		double e = 1;

		for (int n = 1; n <= 14; n = n + 1) {
			e = e + (Stepen.Pow(n, x) / Fact.factorial(n));

		}
		return e;
	}

	public static double Arcsin(double x) {
		double arcsin = x;
        double a=1;
        double b=1;
		for (int n = 3; n <= 31; n=n+2) {
			a=a*n-2;
			b=b*n*(n-1);
			arcsin = arcsin + ((a*Stepen.Pow(n, x)) / (b*Fact.factorial(n)));
            b=b/n;
		}
		return arcsin;
	}

	public static double Arctg(double x) {
		double arctg = x;

		for (int n = 3; n <= 27; n = n + 4) {

			arctg = arctg - (Stepen.Pow(n, x) / n);

			arctg = arctg + (Stepen.Pow(n + 2, x) / n + 2);

		}
		return arctg;
	}

}
