package Form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonModel {
	private String email = null;
	private String password = null;
	private String sex = null;
	private String subscription = null;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {

		if (subscription != null) {
			this.subscription = "signed";
		} else
			this.subscription = "no signed";
	}

	public boolean checkEmail() {
		boolean checkEmail = false;
		Pattern pat = Pattern.compile("^[\\w]{1}[\\w-\\.]*@[\\w-]+\\.[a-z]{2,4}$");
		Matcher match1 = pat.matcher(email);
		if (email != null && match1.matches() == true) {
			checkEmail = true;
		}
		return checkEmail;
	}

	public boolean checkPassword() {
		boolean checkPassword = false;
		if (password != null && password.length() == 5) {
			checkPassword = true;
		}

		return checkPassword;
	}

	public boolean checkSex() {
		boolean checkSex = false;
		if (sex != null) {
			checkSex = true;
		}
		return checkSex;
	}

	public boolean checkPerson() {
		DB db = new DB();
		boolean checkPerson = false;
		if (db.check(email) == true) {
			checkPerson = true;
		}

		return checkPerson;
	}

	public boolean checkData() {
		boolean checkData = false;
		if (checkEmail() == true && checkPassword() == true && checkSex() == true && checkPerson() == true) {
			checkData = true;
		}

		return checkData;
	}

	public boolean addPerson() {
		boolean addPerson = false;
		if (checkData() == true) {
			DB db = new DB();
			db.add(email, password, sex, subscription);
			addPerson = true;
		}
		return addPerson;
	}

	public String[][] giveData() {
		DB db = new DB();
		String[][] inf = db.giveData();
		return inf;

	}
}
