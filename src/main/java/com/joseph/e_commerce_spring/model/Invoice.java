package com.joseph.e_commerce_spring.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the invoice database table.
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice  {
	private static final long serialVersionUID = 1L;

	@Id
	private int idinvoice;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String paymentProvider;

	private String status;

	@Column(name="total_price")
	private BigDecimal totalPrice;

	// many-to-one association to Cart
	@OneToOne
	private Cart cart;

	//uni-directional many-to-one association to Merchant
	@ManyToOne
	private Merchant merchant;

	@Override
	public int hashCode() {
		return Objects.hash(cart, date, idinvoice, merchant, paymentProvider, status, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Invoice)) {
			return false;
		}
		Invoice other = (Invoice) obj;
		return Objects.equals(cart, other.cart) && Objects.equals(date, other.date) && idinvoice == other.idinvoice
				&& Objects.equals(merchant, other.merchant) && Objects.equals(paymentProvider, other.paymentProvider)
				&& Objects.equals(status, other.status) && Objects.equals(totalPrice, other.totalPrice);
	}

//	//bi-directional many-to-one association to Order
//	@OneToMany(mappedBy="invoice")
//	private List<Order> orders;

//	public Invoice() {
//	}
//
//	public int getIdinvoice() {
//		return this.idinvoice;
//	}
//
//	public void setIdinvoice(int idinvoice) {
//		this.idinvoice = idinvoice;
//	}
//
//	public Date getDate() {
//		return this.date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public String getPaymentProvider() {
//		return this.paymentProvider;
//	}
//
//	public void setPaymentProvider(String paymentProvider) {
//		this.paymentProvider = paymentProvider;
//	}
//
//	public String getStatus() {
//		return this.status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public BigDecimal getTotalPrice() {
//		return this.totalPrice;
//	}
//
//	public void setTotalPrice(BigDecimal totalPrice) {
//		this.totalPrice = totalPrice;
//	}
//
//	public List<Cart> getCarts() {
//		return this.carts;
//	}
//
//	public void setCarts(List<Cart> carts) {
//		this.carts = carts;
//	}
//
//	public Cart addCart(Cart cart) {
//		getCarts().add(cart);
//
//		return cart;
//	}
//
//	public Cart removeCart(Cart cart) {
//		getCarts().remove(cart);
//
//		return cart;
//	}
//
//	public Merchant getMerchant() {
//		return this.merchant;
//	}
//
//	public void setMerchant(Merchant merchant) {
//		this.merchant = merchant;
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
//		order.setInvoice(this);
//
//		return order;
//	}
//
//	public Order removeOrder(Order order) {
//		getOrders().remove(order);
//		order.setInvoice(null);
//
//		return order;
//	}

}