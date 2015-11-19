package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Product;



public class Repository {
	public  void add(Product product) {
	    Connection conn = DbWrapper.DBConnection();
	    try {
	      
	      PreparedStatement st= conn.prepareStatement("INSERT INTO products(name,proizvoditeli,ves,category)VALUES(?,?,?,?)");
	      st.setString(1, product.getName());
	      st.setString(2,product.getProizvoditel());
	      st.setInt(3, product.getVes());
	      st.setString(4,product.getCategory());
	      st.execute();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }    
	  }
	public ArrayList<Product> getProducts() {
ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			Connection con = DbWrapper.DBConnection();
            PreparedStatement ps = con.prepareStatement("SELECT id,name,proizvoditeli,ves,category FROM products");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String proizvoditeli = resultSet.getString(3);
				int ves = resultSet.getInt(4);
				String category = resultSet.getString(5);
				products.add(new Product(id,name,proizvoditeli,ves,category));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
		
		
		
		
	}
}
