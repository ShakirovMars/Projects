package Game;

import java.util.Random;

public class GeneratorRandomlLetter {

	public char randomLetter() {
		char arr[] = { 'à','á', 'â', 'ã', 'ä','å', 'æ', 'ç','è', 'ê', 'ë', 'ì', 'í', 'î','ï', 'ð', 'ñ', 'ò','ó' };
		char ch;

		Random rand = new Random();

		ch = (arr[rand.nextInt(arr.length)]);

		return ch;
	}
}