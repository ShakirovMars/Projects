package Model;

public class Product {
	private int id;
	private String name;
	private String proizvoditel;
	private int ves;
    private String  category;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProizvoditel() {
		return proizvoditel;
	}

	public void setProizvoditel(String proizvoditel) {
		this.proizvoditel = proizvoditel;
	}

	public int getVes() {
		return ves;
	}

	public void setVes(int ves) {
		this.ves = ves;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public Product(int id, String name, String proizvoditel, int ves ,String category) {
		this.id = id;
		this.name = name;
		this.proizvoditel = proizvoditel;
		this.ves = ves;
		this.setCategory(category);
	}

	public Product(String name, String proizvoditel, int ves, String category) {
		this.name = name;
		this.proizvoditel = proizvoditel;
		this.ves = ves;
        this.setCategory(category);
	}

	
}
