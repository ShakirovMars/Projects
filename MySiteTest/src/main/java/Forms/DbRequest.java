package Forms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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

	public PersonModel checkPerson(String email, String password) {
		boolean checkPerson = false;
		PersonModel person=null;
		ArrayList<PersonModel> persons = giveData();

		if (persons.isEmpty() == false) {
			for (int i = 0; i < persons.size() && checkPerson == false; i++) {
				if (persons.get(i).getEmail().equals(email) && persons.get(i).getPassword().equals(password)) {
					checkPerson = true;
		person=new PersonModel(persons.get(i).getId(),email, password, persons.get(i).getSex(), persons.get(i).getSubscription(),persons.get(i).getInf());		
               }
			}
		}
		return person;
	}

	public ArrayList<PersonModel> giveData() {
		ArrayList<PersonModel> persons = new ArrayList<PersonModel>();
		
		try {
			Connection con = DBConnection();
			ResultSet r = con.createStatement().executeQuery("select * from Users");
           
			while (r.next()) {
				int id=r.getInt("id");
				String email = r.getString("email");
				String password = r.getString("pass");
				String sex = r.getString("sex");
				String subscription = r.getString("sub");
				String inf = r.getString("inf");
				persons.add(new PersonModel(id,email, password, sex, subscription, inf));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return persons;
	}
	public void addPosts(int UserId,String text){
		Connection con = DBConnection();

		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("INSERT INTO Posts(UserId,text,date_post) VALUES(?,?, GetDate() )");
			
			preparedStatement.setInt(1, UserId);
			preparedStatement.setString(2, text);
			
			preparedStatement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}
	public ArrayList<Posts> givePosts(){
		ArrayList<Posts> posts = new ArrayList<Posts>();
		try {
			Connection con = DBConnection();
			ResultSet r = con.createStatement().executeQuery("select Posts.*,Users.email from Users,Posts where UserId=Users.id");
           
			while (r.next()) {
				int id=r.getInt("id");
				int UserId=r.getInt("UserId");
				String text = r.getString("text");
				Date date =r.getDate("date_post");
				Time time=r.getTime("date_post");
				String email=r.getString("email");
				posts.add(new Posts(id,text,date,time,UserId,email));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}
}
