package com.example.task005;

public class Matrix {
	private double[][] matrix;
	private int stroki;
	private int stolbsi;

	public void setMatrix(double matrix[][]) {
		this.matrix = matrix;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public void setStroki(int stroki) {
		this.stroki = stroki;
	}

	public int getStroki() {
		return stroki;
	}

	public void setStolbsi(int stolbsi) {
		this.stolbsi = stolbsi;
	}

	public int getStolbsi() {
		return stolbsi;
	}

	public Matrix(double[][] matrix, int stroki, int stolbsi) {
		this.matrix = matrix;
		this.stroki = stroki;
		this.stolbsi = stolbsi;
	}

	public void sumMatrix() {
		double matrix1[][] = new double[stroki][stolbsi];
		for (int i = 0; i < stroki; i++) {
			for (int j = 0; j < stolbsi; j++) {
				matrix[i][j] = matrix1[i][j] + matrix[i][j];
			}
		}
	}

	public void multNamMatrix(int chislo) {
		for (int i = 0; i < stroki; i++) {
			for (int j = 0; j < stolbsi; j++) {
				matrix[i][j] = matrix[i][j] * chislo;
			}
		}
	}

	public void multMatrMatrix(int stolbsi1, double matrix1[][]) {

		double matrix2[][] = new double[stroki][stolbsi1];
		double l = 0;
		for (int i = 0; i < stroki; i++) {
			for (int j = 0; j < stolbsi1; j++) {
				for (int k = 0; k < stolbsi; k++) {
					l += matrix[i][k] * matrix1[k][j];
				}
				matrix2[i][j] = l;
				l = 0;
			}
		}
		matrix = matrix2;
		stolbsi = stolbsi1;
	}

	public void transMatrix() {

		int stroki1 = stolbsi;
		int stolbsi1 = stroki;
		double matrix2[][] = new double[stroki1][stolbsi1];
		if (stolbsi == 1) {
			System.out.print("error");
		} else {

			for (int i = 0; i < stroki; i++) {
				for (int j = 0; j < stolbsi; j++) {
					matrix2[j][i] = matrix[i][j];
				}
			}
		}
		matrix = matrix2;
		stolbsi = stolbsi1;
		stroki = stroki1;
	}

	public void sysoMatrix() {
		for (int i = 0; i < stroki; i++) {
			System.out.print("\n");
			for (int j = 0; j < stolbsi; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

}
