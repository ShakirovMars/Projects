package com.example.task002;

public class Monitor {
	public double diagonal;
	public String resolution;
	public double width;
	public double height;

	public Monitor(String resolution, double width, double height) {
		this.resolution = resolution;
		this.width = width;
		this.height = height;
	}

	public double getDiagonal() {
		return Math.sqrt(width * width + height * height);
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

}
