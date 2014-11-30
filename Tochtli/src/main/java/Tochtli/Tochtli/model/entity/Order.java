package Tochtli.Tochtli.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_Order")
/* 'order' is a reserved name, so hibernate will skip it when creating tables!!! */
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;

	@Column(name = "TOTAL")
	private double total;
	
	@Column(name = "DATE")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * Since the OrderedProduct is not a pure join table, but has additional
	 * functional fields, we must map it as an entity, and decompose the many to
	 * many association between 2 many to many
	 */
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderedProduct> orderedProducts;

	public Order() {
		total = 0;
		orderedProducts = new ArrayList<OrderedProduct>();
	}

	public void addToTotal(int quantity, double price) {
		this.total += quantity * price;
	}

	public void addOrderedProduct(OrderedProduct op) {
		if (orderedProducts == null) {
			orderedProducts = new ArrayList<OrderedProduct>();
		}
		this.orderedProducts.add(op);
		op.setOrder(this);
	}

	/* getters and setters */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

}
