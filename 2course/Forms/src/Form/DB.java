package Form;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DB {

	public void add(String email, String password, String sex, String subscription) {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("C:\\Users\\Марсель\\workspace\\Forms\\data.txt", true);
			try {

				fileWriter.write(email + "*" + password + "*" + sex + "*" + subscription + "\r\n");
			} finally {

				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean check(String email) {
		ArrayList<String> forms = new ArrayList<String>();

		boolean checkPerson = true;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\Марсель\\workspace\\Forms\\data.txt"));
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
		if (forms.isEmpty() == false) {
			String person;
			String data;
			for (int i = 0; i < forms.size() && checkPerson == true; i++) {
				data = forms.get(i).toString();
				person = data.substring(0, data.indexOf("*"));
				if (person.equals(email)) {
					checkPerson = false;
				}
			}
		}
		return checkPerson;
	}

	public String[][] giveData() {
		ArrayList<String> forms = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\Марсель\\workspace\\Forms\\data.txt"));
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

		String[][] inf = new String[forms.size()][4];
		if (forms.isEmpty() != true) {
			String data = null;
			StringBuffer data1 = new StringBuffer();
			for (int i = 0; i < forms.size(); i++) {

				data = forms.get(i).toString();
				data1.append(data);

				int t;
				int u;
				t = data1.lastIndexOf("*");
				u = data1.length();
				inf[i][3] = data1.substring(t + 1, u);
				data1.delete(t, u);
				t = data1.lastIndexOf("*");
				u = data1.length();
				inf[i][2] = data1.substring(t + 1, u);
				data1.delete(t, u);
				t = data1.indexOf("*");
				u = data1.length();
				inf[i][1] = data1.substring(t + 1, u);
				data1.delete(t, u);
				t = 0;
				u = data1.length();
				inf[i][0] = data1.substring(t, u);
				data1.delete(t, u);
			}
		}
		return inf;

	}
}
