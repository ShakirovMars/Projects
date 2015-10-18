package Form;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonModel {
	private String email = null;
	private String password = null;
	private String sex = null;
	private String subscription = null;
	private String inf=null;

	public PersonModel(String email, String password, String sex, String subscription, String inf) {
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.subscription = subscription;
		this.inf=inf;
	}

	public String getInf() {
		return inf;
	}

	public void setInf(String inf) {
		this.inf = inf;
	}

	public PersonModel(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

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
		this.subscription = subscription;
	}

	public boolean checkEmail() {
		boolean checkEmail = false;
		Pattern pat = Pattern.compile("^[\\w]{1}[\\w-\\.]*@[\\w-]+\\.[a-z]{2,4}$");
		Matcher match1 = pat.matcher(email);
		if (match1.matches() == true) {
			checkEmail = true;
		}
		return checkEmail;
	}

	public boolean checkPassword() {
		boolean checkPassword = false;
		if (password.length() == 5) {
			checkPassword = true;
		}

		return checkPassword;
	}

	public boolean checkEmailDb() {
		DB db = new DB();
		boolean checkPerson = false;
		if (db.checkEmail(email) == true) {
			checkPerson = true;
		}

		return checkPerson;
	}
	public boolean checkPerson() {
		DB db = new DB();
		boolean checkPerson = false;
		if (db.checkPerson(email,password) == true) {
			checkPerson = true;
		}

		return checkPerson;
	}
	
	

	public boolean checkData() {
		boolean checkData = false;
		if (checkEmail() == true && checkPassword() == true && checkEmailDb() == true) {
			checkData = true;
		}

		return checkData;
	}

	public boolean addPerson() {
		boolean addPerson = false;
		if (checkData() == true) {
			DB db = new DB();
			db.add(email, password, sex, subscription,inf);
			addPerson = true;
		}
		return addPerson;
	}

	public ArrayList<PersonModel> giveData() {
		DB db = new DB();
		ArrayList<PersonModel> persons = db.giveData();
		return persons;

	}
}
