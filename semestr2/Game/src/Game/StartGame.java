package Game;

import java.util.Scanner;

public class StartGame {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����� ���������� � ���� ��������� ������� ������!");
		Thread.sleep(1000);
		System.out.println("O���������� � ������������ ����:");
		Thread.sleep(1000);
		System.out
				.println("�� ����������,���� �������� �� ������ ������������� �� ����-�����");
		Thread.sleep(1000);
		System.out.println("��� ������ 200 ������ ���������");
		Thread.sleep(1000);
		System.out.println("����� ����������");
		Thread.sleep(1000);
		System.out.println("��� ���� ����� ��������� ������� ��������� �����:");
		Thread.sleep(1000);
		System.out.println("�����");
		Thread.sleep(500);
		System.out.println("������");
		Thread.sleep(500);
		System.out.println("����");
		Thread.sleep(500);
		System.out.println("�����");
		Thread.sleep(500);
		System.out.println("��� �������� �������:");
		Thread.sleep(1000);
		System.out.println("�����");
		Thread.sleep(500);
		System.out.println("������");
		Thread.sleep(500);
		System.out.println("�����");
		Thread.sleep(500);
		System.out.println("�� �����");
		Thread.sleep(500);
		System.out.println("������");
		Thread.sleep(1000);
		System.out.println("����� ��������� ");
		Thread.sleep(1000);
		System.out.println("������� ��������������� �����");
		Thread.sleep(500);
		System.out.println("1)��������");
		Thread.sleep(500);
		System.out.println("2)��������");
		Thread.sleep(500);
		System.out.println("3)������������");
		Thread.sleep(500);
		System.out.println("4)���������");
		Thread.sleep(500);
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (n != 1 || n != 2 || n != 3 || n != 4) {
			n = sc.nextInt();

			if (n == 1 || n == 2 || n == 3 || n == 4) {
				if (n == 1) {
					Leonardo leonardo = new Leonardo();
					leonardo.getName();
					System.out.println("����� " + leonardo.getXP());
				}

				if (n == 2) {
					Raffaello raffaello = new Raffaello();
					raffaello.getName();
					System.out.println("����� " + raffaello.getXP());

				}
				if (n == 3) {
					Michelangelo michelangelo = new Michelangelo();
					michelangelo.getName();
					System.out.println("����� " + michelangelo.getXP());
				}
				if (n == 4) {
					Donatello donatello = new Donatello();
					donatello.getName();
					System.out.println("����� " + donatello.getXP());
				}

				Player player = new Player();

				FirstFloor firstFloor = new FirstFloor(player);
				firstFloor.play();

			} else
				System.out.println("������� ���������� �����");

		}

	}
}