package Game;

import java.util.Scanner;

public class StartGame {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Добро пожаловать в игру черепашки мутанты ниндзя!");
		Thread.sleep(1000);
		System.out.println("Oзнакомтесь с инструкциями игры:");
		Thread.sleep(1000);
		System.out
				.println("Вы побеждаете,если пройдете до пункта обозначенного на мини-карте");
		Thread.sleep(1000);
		System.out.println("Вам дается 200 единиц прочности");
		Thread.sleep(1000);
		System.out.println("Опции управления");
		Thread.sleep(1000);
		System.out.println("Для того чтобы двигаться вводите следующие слова:");
		Thread.sleep(1000);
		System.out.println("Влево");
		Thread.sleep(500);
		System.out.println("Вправо");
		Thread.sleep(500);
		System.out.println("Вниз");
		Thread.sleep(500);
		System.out.println("Вверх");
		Thread.sleep(500);
		System.out.println("Для действий вводите:");
		Thread.sleep(1000);
		System.out.println("Атака");
		Thread.sleep(500);
		System.out.println("Бежать");
		Thread.sleep(500);
		System.out.println("Взять");
		Thread.sleep(500);
		System.out.println("Не брать");
		Thread.sleep(500);
		System.out.println("Пройти");
		Thread.sleep(1000);
		System.out.println("Выбор персонажа ");
		Thread.sleep(1000);
		System.out.println("Введите соответствующую цифру");
		Thread.sleep(500);
		System.out.println("1)Леонардо");
		Thread.sleep(500);
		System.out.println("2)Рафаэлло");
		Thread.sleep(500);
		System.out.println("3)Микеланджело");
		Thread.sleep(500);
		System.out.println("4)Донателло");
		Thread.sleep(500);
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (n != 1 || n != 2 || n != 3 || n != 4) {
			n = sc.nextInt();

			if (n == 1 || n == 2 || n == 3 || n == 4) {
				if (n == 1) {
					Leonardo leonardo = new Leonardo();
					leonardo.getName();
					System.out.println("Жизнь " + leonardo.getXP());
				}

				if (n == 2) {
					Raffaello raffaello = new Raffaello();
					raffaello.getName();
					System.out.println("Жизнь " + raffaello.getXP());

				}
				if (n == 3) {
					Michelangelo michelangelo = new Michelangelo();
					michelangelo.getName();
					System.out.println("Жизнь " + michelangelo.getXP());
				}
				if (n == 4) {
					Donatello donatello = new Donatello();
					donatello.getName();
					System.out.println("Жизнь " + donatello.getXP());
				}

				Player player = new Player();

				FirstFloor firstFloor = new FirstFloor(player);
				firstFloor.play();

			} else
				System.out.println("Введите правильное число");

		}

	}
}