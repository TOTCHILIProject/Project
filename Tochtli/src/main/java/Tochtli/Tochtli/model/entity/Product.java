package Tochtli.Tochtli.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;

	@Column(name = "UNITS")
	private String units;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "STOCK")
	private double stock;

	/* for the instance we don't store images, but the image path */
	@Column(name = "PHOTO_PATH")
	private String photo_path;

	/*
	 * IF the invers relationship is needed
	 * 
	 * @OneToMany(mappedBy = "product") private Set<OrderedProduct> orders = new
	 * HashSet<OrderedProduct>();
	 */

	public Product() {

	}

	public Product(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Product(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public String getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}

}
