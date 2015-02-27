package Game;

import java.util.Scanner;

public class RoomWithNinja {

	public static  boolean Ninja = false;

	public static void RoomWithNinja(Player player) {

		System.out.println("Комната с ниндзя");
		System.out.println("Атакуйте");
		System.out
				.println("Подсказска: введите атака или бежать, но учтите сбежав вы переместитесь в начальную точку");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();

		player.moveByCommand(cmd1);
		if (player.getAttack() == true) {

			System.out.println("Отлично, вы победили Ниндзя!");
			System.out
					.println("Интуиция подсказывает мне, что аптечка может быть в соседней комнате справа");
			player.XP = player.XP - 50;
			System.out.println("Жизнь " + player.getXP());
			Ninja = true;
			player.tranquility();
		}
		if (player.getElope() == true) {
			System.out.println("Вы бежали, придется начинать путь заново");
			System.out.println("Жизнь " + player.getXP());
		}

	}
}
