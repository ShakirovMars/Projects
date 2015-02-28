package com.example.task003;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Sin(x)="+TrigonometrMath.Sin(45));
		System.out.println("Cos(x)"+TrigonometrMath.Cos(90));
		System.out.printf("e^x="+"%.1f\n",TrigonometrMath.E(5));
		System.out.println("Arctg(x)="+TrigonometrMath.Arctg(0.5));
		System.out.println("Arcsin(x)="+TrigonometrMath.Arcsin(0.5));
	}
}
