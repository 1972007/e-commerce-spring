package com.joseph.e_commerce_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cart")
//@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart   {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcart;

	private int amount;
	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="product_iditem")
	private Item item;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne
	@JoinColumn(name="userInfo_userId")
	private Userinfo userinfo;
//	//bi-directional many-to-one association to Invoice
//	@ManyToOne
//	@JoinColumn(name="idcart", referencedColumnName="cart_idcart")
//	private Invoice invoice;
//


//	//bi-directional many-to-one association to Item
//	@OneToMany
//	private List<Item> items;

	public Cart() {
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, idcart, item, userinfo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cart)) {
			return false;
		}
		Cart other = (Cart) obj;
		return amount == other.amount && idcart == other.idcart && Objects.equals(item, other.item)
				&& Objects.equals(userinfo, other.userinfo);
	}
	
//
//	public int getIdcart() {
//		return this.idcart;
//	}
//
//	public void setIdcart(int idcart) {
//		this.idcart = idcart;
//	}
//
//	public int getAmount() {
//		return this.amount;
//	}
//
//	public void setAmount(int amount) {
//		this.amount = amount;
//	}

//	public Invoice getInvoice() {
//		return this.invoice;
//	}
//
//	public void setInvoice(Invoice invoice) {
//		this.invoice = invoice;
//	}
//
//	public Item getItem() {
//		return this.item;
//	}
//
//	public void setItem(Item item) {
//		this.item = item;
//	}

//	public Userinfo getUserinfo() {
//		return this.userinfo;
//	}
//
//	public void setUserinfo(Userinfo userinfo) {
//		this.userinfo = userinfo;
//	}
//
//	public List<Item> getItems() {
//		return this.items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}

//	public Item addItem(Item item) {
//		getItems().add(item);
//		item.setCart(this);
//
//		return item;
//	}
//
//	public Item removeItem(Item item) {
//		getItems().remove(item);
//		item.setCart(null);
//
//		return item;
//	}

}