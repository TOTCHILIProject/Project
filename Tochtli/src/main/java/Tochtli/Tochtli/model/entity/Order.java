package Tochtli.Tochtli.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@Column(name = "TOTAL")
	private double total;

	/*
	 * Since the OrderedProduct is not a pure join table, but has additional
	 * functional fields, we must map it as an entity, and decompose the many to
	 * many association between 2 many to many
	 */
	@OneToMany(mappedBy = "order")
	private Set<OrderedProduct> orderedProducts = new HashSet<OrderedProduct>();

	public Order() {

	}

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

	public Set<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(Set<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

}
