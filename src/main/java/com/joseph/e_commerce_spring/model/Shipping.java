package com.joseph.e_commerce_spring.model;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the shipping database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Shipping.findAll", query="SELECT s FROM Shipping s")
public class Shipping  {
	private static final long serialVersionUID = 1L;

	@Id
	private int idshipping;

	private String courier;

	private String method;

	@Override
	public int hashCode() {
		return Objects.hash(courier, idshipping, method);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Shipping)) {
			return false;
		}
		Shipping other = (Shipping) obj;
		return Objects.equals(courier, other.courier) && idshipping == other.idshipping
				&& Objects.equals(method, other.method);
	}

//	//bi-directional many-to-one association to Order
//	@OneToMany(mappedBy="shipping")
//	private List<Order> orders;

//	public Shipping() {
//	}
//
//	public int getIdshipping() {
//		return this.idshipping;
//	}
//
//	public void setIdshipping(int idshipping) {
//		this.idshipping = idshipping;
//	}
//
//	public String getCourier() {
//		return this.courier;
//	}
//
//	public void setCourier(String courier) {
//		this.courier = courier;
//	}
//
//	public String getMethod() {
//		return this.method;
//	}
//
//	public void setMethod(String method) {
//		this.method = method;
//	}

//	public List<Order> getOrders() {
//		return this.orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

//	public Order addOrder(Order order) {
//		getOrders().add(order);
//		order.setShipping(this);
//
//		return order;
//	}
//
//	public Order removeOrder(Order order) {
//		getOrders().remove(order);
//		order.setShipping(null);
//
//		return order;
//	}

}