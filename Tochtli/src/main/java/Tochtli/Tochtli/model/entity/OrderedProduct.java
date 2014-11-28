package Tochtli.Tochtli.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ordered_Product")
/* 'order' is a reserved name, so hibernate will skip it when creating tables!!! */
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "prodct_id")
	private Product product;

	@Column(name = "quantity")
	private int quantity;

	public OrderedProduct() {

	}

	public OrderedProduct(Product p, int q) {
		this.product = p;
		this.quantity = q;
	}

	public void addQuantity(int d) {
		this.quantity += d;
	}

	/* getters and setters */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
