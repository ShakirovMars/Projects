package com.example.task003;

public class Stepen {
	public static double Pow(int n,double x) {
	  double result = 1;
	    for (int i = 0; i < n; i++) {
	        result *= x;
	    }
	    return result;
	}
}
