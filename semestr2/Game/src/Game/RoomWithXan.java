package Game;

import java.util.Scanner;

public class RoomWithXan {

	public static boolean xan;

	public static void RoomWithXan( Player player) {

		System.out.println("Вы встретили главаря пурпурных драконов!!!");
		System.out.println("Атакуйте");
		System.out
				.println("Подсказска: введите атака или бежать, но учтите сбежав вы переместитесь в начальную точку");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getAttack() == true) {

			System.out.println("Отлично, вы победили Хана! ");
			System.out.println("Разведка докладывет,что внизу есть аптечка");
			player.XP = player.XP - 70;
			System.out.println("Жизнь " + player.getXP());
			xan = true;
			player.tranquility();
		}
		if (player.getElope() == true) {
			System.out.println("Вы бежали, придется начинать путь заново");
			System.out.println("Жизнь " + player.getXP());
		}

	}
}
