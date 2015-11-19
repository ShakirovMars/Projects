package Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Product;

public class Check {

	public boolean checkFill(String name,String manufactorer, String weight,String category) {
		boolean checkFill = false;
		
		if (!name.trim().isEmpty() && !manufactorer.trim().isEmpty()  && !weight.trim().isEmpty()  &&
				!category.trim().isEmpty() ) {
			checkFill = true;
		}

		return checkFill;
	}

	public boolean checkValidation( String ves) {
		boolean checkValidation = false;
		
		Pattern pat2 = Pattern.compile("[0-9]*");
		Matcher match2 = pat2.matcher(ves);

		if ( match2.matches() == true) {
			checkValidation = true;
		}

		return checkValidation;
	}

	public boolean checkProizvoditel(Product product) {
		boolean checkProizvoditel = false;
		if (!product.getProizvoditel().equals("Выбрать")) {
			checkProizvoditel = true;
		}
		return checkProizvoditel;
	}

	public boolean checkUniqueness(Product product) {
		boolean checkUniqueness = false;
		Repository repository = new Repository();
		ArrayList<Product> products = repository.getProducts();
		if (products.isEmpty() == false) {
			for (int i = 0; i < products.size() && checkUniqueness == false; i++) {
				if (products.get(i).getName().equals(product.getName())
						&& products.get(i).getProizvoditel().equals(product.getProizvoditel())
						&& products.get(i).getVes() == (product.getVes())
						&& products.get(i).getCategory().equals(product.getCategory())) {
					checkUniqueness = true;
				}
			}
		}
		return checkUniqueness;
	}
}
