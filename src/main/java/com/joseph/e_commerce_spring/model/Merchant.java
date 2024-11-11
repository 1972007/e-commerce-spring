package com.joseph.e_commerce_spring.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the merchant database table.
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name="Merchant.findAll", query="SELECT m FROM Merchant m")
public class Merchant  {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMerchant;

	private String desc;

	private String name;

//	//bi-directional many-to-one association to Item
//	@OneToMany(mappedBy="merchant")
//	private List<Item> items;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne
	@JoinColumn(name="userInfo_userId", referencedColumnName="userId")
	private Userinfo userinfo;

	@Override
	public int hashCode() {
		return Objects.hash(desc, idMerchant, name, userinfo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Merchant)) {
			return false;
		}
		Merchant other = (Merchant) obj;
		return Objects.equals(desc, other.desc) && idMerchant == other.idMerchant && Objects.equals(name, other.name)
				&& Objects.equals(userinfo, other.userinfo);
	}

//	public Merchant() {
//	}
//
//	public int getIdMerchant() {
//		return this.idMerchant;
//	}
//
//	public void setIdMerchant(int idMerchant) {
//		this.idMerchant = idMerchant;
//	}
//
//	public String getDesc() {
//		return this.desc;
//	}
//
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
////	public List<Item> getItems() {
////		return this.items;
////	}
////
////	public void setItems(List<Item> items) {
////		this.items = items;
////	}
////
////	public Item addItem(Item item) {
////		getItems().add(item);
////		item.setMerchant(this);
////
////		return item;
////	}
////
////	public Item removeItem(Item item) {
////		getItems().remove(item);
////		item.setMerchant(null);
////
////		return item;
////	}
//
//	public Userinfo getUserinfo() {
//		return this.userinfo;
//	}
//
//	public void setUserinfo(Userinfo userinfo) {
//		this.userinfo = userinfo;
//	}

}