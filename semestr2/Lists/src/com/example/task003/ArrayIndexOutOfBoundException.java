package com.example.task003;

public class ArrayIndexOutOfBoundException extends Exception {
	@Override
	public String getMessage() {
		return "Index exceeds list";
	}
}
