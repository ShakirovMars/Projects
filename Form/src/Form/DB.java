package Form;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DB {
	String adress = "C:\\Users\\Марсель\\workspace\\Forms\\WebContent\\data.txt";

	public void add(String email, String password, String sex, String subscription,String inf) {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(adress, true);
			try {

				fileWriter.write(email + "*" + password + "*" + sex + "*" + subscription+"*" +inf+ "\r\n");
			} finally {

				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean checkEmail(String email) {
		boolean checkEmail = true;
		ArrayList<PersonModel> persons = giveData();
		if (persons.isEmpty() == false) {
			for (int i = 0; i < persons.size() && checkEmail == true; i++) {
				if (persons.get(i).getEmail().equals(email)) {
					checkEmail = false;
				}
			}
		}
		return checkEmail;
	}

	public boolean checkPerson(String email, String password) {
		boolean checkPerson =false;
		ArrayList<PersonModel> persons = giveData();
		
		if (persons.isEmpty() == false) {
			for (int i = 0; i < persons.size() && checkPerson == false; i++) {
				if (persons.get(i).getEmail().equals(email) && persons.get(i).getPassword().equals(password)) {
					checkPerson = true;
				}
			}
		}
		return checkPerson;
	}

	public ArrayList<PersonModel> giveData() {
		ArrayList<String> forms = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(adress));
			String form;
			try {
				while ((form = reader.readLine()) != null) {
					forms.add(form);
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		ArrayList<PersonModel> persons = new ArrayList<PersonModel>();
		int t;
		int u;
		String email;
		String password;
		String sex;
		String subscription;
		String inf;
		if (forms.isEmpty() != true) {
			String data = null;
			StringBuffer data1 = new StringBuffer();
			for (int i = 0; i < forms.size(); i++) {

				data = forms.get(i).toString();
				data1.append(data);

				t = data1.indexOf("signed*")+6;
				u = data1.length();
				inf=data1.substring(t + 1, u);
				data1.delete(t, u);
				t = data1.lastIndexOf("*");
				u = data1.length();
				subscription = data1.substring(t + 1, u);
				data1.delete(t, u);
				t = data1.lastIndexOf("*");
				u = data1.length();
				sex = data1.substring(t + 1, u);
				data1.delete(t, u);
				t = data1.indexOf("*");
				u = data1.length();
				password = data1.substring(t + 1, u);
				data1.delete(t, u);
				t = 0;
				u = data1.length();
				email = data1.substring(t, u);
				data1.delete(t, u);

				persons.add(new PersonModel(email, password, sex, subscription,inf));
			}
		}
		return persons;

	}
}
