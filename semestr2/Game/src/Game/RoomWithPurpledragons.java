package Game;

import java.util.Scanner;

public class RoomWithPurpledragons {
	public static boolean purpledragons;

	public static void RoomWithPurpledragons(Player player) {

		System.out.println("�� ��������� ����� ��������� ��������!!!");
		System.out.println("��������");
		System.out
				.println("����������: ������� ����� ��� ������, �� ������ ������ �� ������������� � ��������� �����");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getAttack() == true) {

			System.out
					.println("�������, �� �������� ����� ��������� ��������!");
			player.XP = player.XP - 50;
			System.out.println("����� " + player.getXP());
			purpledragons = true;
			player.tranquility();
		}
		if (player.getElope() == true) {
			System.out.println("�� ������, �������� �������� ���� ������");
			System.out.println("����� " + player.getXP());
		}
	}

}
