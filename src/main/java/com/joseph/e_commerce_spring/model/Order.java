package com.joseph.e_commerce_spring.model;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order  {
	private static final long serialVersionUID = 1L;

	@Id
	private int idorder;

	@Column(name="order_status")
	private String orderStatus;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	private Invoice invoice;

	//bi-directional many-to-one association to Shipping
	@ManyToOne
	private Shipping shipping;

	@Override
	public int hashCode() {
		return Objects.hash(idorder, invoice, orderStatus, shipping);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Order)) {
			return false;
		}
		Order other = (Order) obj;
		return idorder == other.idorder && Objects.equals(invoice, other.invoice)
				&& Objects.equals(orderStatus, other.orderStatus) && Objects.equals(shipping, other.shipping);
	}

//	public Order() {
//	}
//
//	public int getIdorder() {
//		return this.idorder;
//	}
//
//	public void setIdorder(int idorder) {
//		this.idorder = idorder;
//	}
//
//	public String getOrderStatus() {
//		return this.orderStatus;
//	}
//
//	public void setOrderStatus(String orderStatus) {
//		this.orderStatus = orderStatus;
//	}
//
//	public Invoice getInvoice() {
//		return this.invoice;
//	}
//
//	public void setInvoice(Invoice invoice) {
//		this.invoice = invoice;
//	}
//
//	public Shipping getShipping() {
//		return this.shipping;
//	}
//
//	public void setShipping(Shipping shipping) {
//		this.shipping = shipping;
//	}

}