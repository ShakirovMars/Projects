package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Check {

	public boolean checkCorrectCity(String City) {
		boolean check = false;
		String city;
		try {
			Connection con = DbWrapper.DBConnection();
			PreparedStatement ps = con.prepareStatement("SELECT  city_name_ru FROM city ");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next() && !check) {
				city = resultSet.getString(1);
				if (city.equalsIgnoreCase(City)) {
					check = true;

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	public boolean checkFirstLetter(char FirstLetter, String City) {
		boolean check = false;
		if (City.toLowerCase().charAt(0) == FirstLetter) {
			check = true;
		}

		return check;
	}

	public char nextLetter(String City) {

		char letter;
		int i = 2;
		letter = City.toLowerCase().charAt(City.length() - 1);
		while (!correctLetter(letter)) {

			if (City.length()-i>0) {
				letter = City.toLowerCase().charAt(City.length() - i);
				i++;
			} else {
				letter = '-';
				break;
			}

		}

		return letter;
	}

	public boolean correctLetter(char letter) {
	
		boolean correct = false;
		int i = 0;
		String city;
		try {
			Connection con = DbWrapper.DBConnection();
			PreparedStatement ps = con.prepareStatement("SELECT  city_name_ru FROM city ");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				city = resultSet.getString(1);
				if (city.toLowerCase().charAt(0) == letter) {
					i++;

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (i >= 5) {
			
			correct = true;
		}

		return correct;
	}

	public boolean checkRepeat(ArrayList<String> CitiesPlayers, String City) {
		boolean check = true;
		if (!CitiesPlayers.isEmpty()) {
			for (int i = 0; i < CitiesPlayers.size() && check; i++) {
				if (CitiesPlayers.get(i).equalsIgnoreCase(City)) {
					check = false;
				}
			}
		} 
		return check;
	}

	public char mainCheck(char FirstLetter, String City, ArrayList<String> CitiesPlayers) {
		char nextLetter = '*';
		if (checkFirstLetter(FirstLetter, City)) {

			if (checkCorrectCity(City)) {

				if (checkRepeat(CitiesPlayers, City)) {
					nextLetter = nextLetter(City);
				} else
					nextLetter = '#';

			}

		}

		return nextLetter;
	}

}
