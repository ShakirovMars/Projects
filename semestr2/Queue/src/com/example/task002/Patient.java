package com.example.task002;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Patient {
	public String name;

	public Patient(String name) {
		this.name = name;

	}

	public static void main(String args[]) {
		boolean end = false;
		boolean in = false;

		String command;
		Queue<Patient> queue1 = new LinkedList<Patient>();
		Queue<Patient> queue2 = new LinkedList<Patient>();
		Scanner sc = new Scanner(System.in);
		while (!end) {
			command = sc.next();

			switch (command) {
			case "CamePatientWithTicket":
				System.out.println("input name");
				String name = sc.next();

				Patient patient = new Patient(name);
				queue1.add(patient);
				System.out.println(patient.name + " " + " Dobavlen v ochered");

				in = false;

				break;
			case "CamePatientWithoutTicket":
				System.out.println("input name");
				String name1 = sc.next();

				Patient patient1 = new Patient(name1);

				queue2.add(patient1);
				System.out.println(patient1.name + " " + " Dobavlen v ochered");
				in = true;
				break;
			case "DoctorIsFree":

				if (queue1.size() != 0 || queue2.size() != 0) {
					if (in == false) {
						Patient patient2 = new Patient(null);
						patient2 = queue1.poll();

						System.out.println(patient2.name + " "
								+ "s talonom poshel k vrachy ");
						in = true;
						if (queue2.size() == 0) {
							in = false;
						}

						break;
					}
					if (in == true) {
						Patient patient3 = new Patient(null);
						patient3 = queue2.poll();

						System.out.println(patient3.name + " "
								+ "bez talona poshel k vrachy ");
						in = false;
						if (queue1.size() == 0) {
							in = true;
						}

						break;

					}
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
