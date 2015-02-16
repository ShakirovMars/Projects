package com.example.task003;

public class ComplexNumbers {
	public double realPart;
	public double imaginaryPart;

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getRealPart() {
		return realPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public ComplexNumbers(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public ComplexNumbers SummaComplexNumbers(ComplexNumbers c1,
			ComplexNumbers c2) {
		ComplexNumbers s;
		s= new ComplexNumbers(c1.realPart + c2.realPart, c1.imaginaryPart
				+ c2.imaginaryPart);
		return  s;
	}

	public ComplexNumbers MultiplicationComplexNumbers(ComplexNumbers c1,
			ComplexNumbers c2) {
		ComplexNumbers m;
		m= new ComplexNumbers(c1.realPart * c2.realPart - c1.imaginaryPart
				* c2.imaginaryPart, c1.realPart * c2.imaginaryPart
				+ c1.imaginaryPart * c2.realPart);
		return m;
	}

	public ComplexNumbers ModuleComplexNumbers(ComplexNumbers c1) {
		ComplexNumbers mod;
		mod=new ComplexNumbers(Math.sqrt(c1.realPart * c1.realPart
				+ c1.imaginaryPart * c1.imaginaryPart), 0);
		return mod;
	}
	
}
