package Game;

import java.util.Scanner;

public class RoomWithXan {

	public static boolean xan;

	public static void RoomWithXan( Player player) {

		System.out.println("�� ��������� ������� ��������� ��������!!!");
		System.out.println("��������");
		System.out
				.println("����������: ������� ����� ��� ������, �� ������ ������ �� ������������� � ��������� �����");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getAttack() == true) {

			System.out.println("�������, �� �������� ����! ");
			System.out.println("�������� ����������,��� ����� ���� �������");
			player.XP = player.XP - 70;
			System.out.println("����� " + player.getXP());
			xan = true;
			player.tranquility();
		}
		if (player.getElope() == true) {
			System.out.println("�� ������, �������� �������� ���� ������");
			System.out.println("����� " + player.getXP());
		}

	}
}
