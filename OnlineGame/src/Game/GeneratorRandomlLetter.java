package Game;

import java.util.Random;

public class GeneratorRandomlLetter {

	public char randomLetter() {
		char arr[] = { '�','�', '�', '�', '�','�', '�', '�','�', '�', '�', '�', '�', '�','�', '�', '�', '�','�' };
		char ch;

		Random rand = new Random();

		ch = (arr[rand.nextInt(arr.length)]);

		return ch;
	}
}