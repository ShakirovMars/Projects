package com.example.task003;

public class Main {
	public static void main(String[] args) {
		ComplexNumbers c1 = new ComplexNumbers(8, 4);
		ComplexNumbers c2 = new ComplexNumbers(6, 2);
		ComplexNumbers c3 = new ComplexNumbers(0, 0);
		c3 = c3.SummaComplexNumbers(c1, c2);
		System.out.println(c3.realPart + "+" + c3.imaginaryPart + "i");
		c3 = c3.MultiplicationComplexNumbers(c1, c2);
		System.out.println(c3.realPart + "+" + c3.imaginaryPart + "i");
		c3 = c3.ModuleComplexNumbers(c1);
		System.out.println(c3.realPart);
		c3 = c3.ModuleComplexNumbers(c2);
		System.out.println(c3.realPart);
	}
}
