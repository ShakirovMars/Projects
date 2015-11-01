package Form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbRequest {

	public Connection DBConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String server = "localhost\\sqlexpress";
			int port = 1433;
			String user = "sa"; // Sql server username
			String password = "mars1996";
			String database = "Users";

			String jdbcUrl = "jdbc:sqlserver://" + server + ":" + port + ";user=" + user + ";password=" + password
					+ ";databaseName=" + database + "";

			con = DriverManager.getConnection(jdbcUrl);
			

		} catch (Exception ex) {
			System.out.println("Error : " + ex);
		}
		return con;
	}

	public void add(String email, String password, String sex, String subscription, String inf) {
		Connection con = DBConnection();

		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO Users(email, pass, sex, sub, inf) VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, sex);
			preparedStatement.setString(4, subscription);
			preparedStatement.setString(5, inf);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		boolean checkPerson = false;
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
		ArrayList<PersonModel> persons = new ArrayList<PersonModel>();
		
		try {
			Connection con = DBConnection();
            PreparedStatement ps = con.prepareStatement("SELECT email, pass, sex, sub, inf FROM Users");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String email = resultSet.getString(1);
				String password = resultSet.getString(2);
				String sex = resultSet.getString(3);
				String subscription = resultSet.getString(4);
				String inf = resultSet.getString(5);
				persons.add(new PersonModel(email, password, sex, subscription, inf));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return persons;
	}
}
