package com.example.task005;

import java.util.Scanner;

import com.example.task005.Matrix;

public class Main {
	public static void main(String[] args) {
		System.out.println("vvedite kolichestvo strok v 1 matrisi");
		Scanner sc = new Scanner(System.in);
		int stroki = sc.nextInt();
		System.out.println("vvedite kolichestvo stolbsov v 1 matrisi ");
		int stolbsi = sc.nextInt();
		double[][] matrix = new double[stroki][stolbsi];

		System.out.println("vvedite elementi 1 matrisi");
		for (int i = 0; i < stroki; i++) {
			for (int j = 0; j < stolbsi; j++) {

				matrix[i][j] = sc.nextDouble();
			}
		}

		System.out.println("vvedite kolichestvo stolbsov vo 2 matrisi ");
		int stolbsi1 = sc.nextInt();
		double[][] matrix1 = new double[stolbsi][stolbsi1];
		System.out.println("vvedite elementi vo 2 matrisi");
		for (int i = 0; i < stolbsi; i++) {
			for (int j = 0; j < stolbsi1; j++) {

				matrix1[i][j] = sc.nextDouble();

			}
		}

		sc.close();

		Matrix matr = new Matrix(matrix, stroki, stolbsi);
		matr.multMatrMatrix(stolbsi1, matrix1);
		// *matr.multNamMatrix(2);
		// *matr.transMatrix();
		matr.sysoMatrix();
	}
}
