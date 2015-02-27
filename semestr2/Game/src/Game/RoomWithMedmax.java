package Game;

import java.util.Scanner;

public class RoomWithMedmax {
	public static boolean medmax;

	public static void RoomWithMedmax( Player player) {
		System.out.println("Вы нашли большую аптечку");
		System.out.println("Возьмите");
		System.out.println("Подсказска: введите взять или не брать");
		Scanner scan = new Scanner(System.in);
		String cmd1 = scan.next();
		player.moveByCommand(cmd1);
		if ((player.getTake() == true) && (player.getXP() <= 200)) {
			System.out.println("Отлично, вы пополнили здоровье");
			System.out.println("Жизнь " + player.getXP());
			player.getNottake();
			medmax = true;
		} else {
			if (player.getTake() == false && (player.getXP() >= 200)) {
				System.out
						.println("У вас максимальное здоровье,можете прийти за ним позже");
				System.out.println(player.getXP());
			} else {
				if (player.getXP() < 200) {
					System.out.println("A,зряя!!");
					System.out.println("Жизнь " + player.getXP());
				}
			}
		}
	}
}
