package task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
	public boolean regularCheck(String m) {
		boolean regularCheck = false;
		Pattern pat = Pattern
				.compile("^[\\w]{1}[\\w-\\.]*@[\\w-]+\\.[a-z]{2,4}$");
		Matcher match1 = pat.matcher(m);
		if (match1.matches() == true) {
			regularCheck = true;
		}
		System.out.println("e-mail: " + regularCheck);
		return regularCheck;
	}

	public void regulardDivision(String m) {
		if (regularCheck(m) == true) {
			Pattern pat1 = Pattern.compile("@");
			String[] words = pat1.split(m);
			for (String word : words)
				System.out.println(word);
		}
	}
}
