package com.example.task001;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Student {
	public String name;
	public String surname;
	public String patronymic;
	public String faculty;
	public int group;

	public Student(String name, String surname, String patronymic,
			String faculty, int group) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.faculty = faculty;
		this.group = group;
	}

	public static void main(String args[]) {
		boolean end = false;
		String command;
		Queue<Student> queue = new LinkedList<Student>();
		Scanner sc = new Scanner(System.in);

		while (!end) {
			command = sc.next();

			switch (command) {
			case "AddStudent":

				System.out.println("input name");
				String name = sc.next();
				System.out.println("input surname");
				String surname = sc.next();
				System.out.println("input patronymic");
				String patronymic = sc.next();
				System.out.println("input faculty");
				String faculty = sc.next();
				System.out.println("input  group");
				int group = sc.nextInt();

				Student student = new Student(name, surname, patronymic,
						faculty, group);

				queue.add(student);
				System.out.println(student.name + " " + student.surname + " "
						+ student.patronymic + " Dobavlen v ochered");

				break;
			case "GiveTicket":
				if (queue.size()!= 0) {
					Student student1 = new Student(null, null, null, null, 0);
					student1 = queue.poll();
					System.out.println(student1.name + " " + student1.surname
							+ " " + student1.patronymic
							+ " Poluchil talon i poshel kyshat");
				} else
					System.out.println("Net ocheredi");
					
				
				break;
			case "End":
				end = true;
				break;
			default:
				break;

			}

		}

		sc.close();
	}

}
