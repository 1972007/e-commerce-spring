package com.joseph.e_commerce_spring.model;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the wishlist database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Wishlist.findAll", query="SELECT w FROM Wishlist w")
public class Wishlist  {
	private static final long serialVersionUID = 1L;

	@Id
	private int idwishlist;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to Userinfo
	
	@ManyToOne
	@JoinColumn(name="userInfo_userId", referencedColumnName="userId"	)
	private Userinfo userinfo;

	@Override
	public int hashCode() {
		return Objects.hash(idwishlist, item, userinfo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Wishlist)) {
			return false;
		}
		Wishlist other = (Wishlist) obj;
		return idwishlist == other.idwishlist && Objects.equals(item, other.item)
				&& Objects.equals(userinfo, other.userinfo);
	}

//	public Wishlist() {
//	}
//
//	public int getIdwishlist() {
//		return this.idwishlist;
//	}
//
//	public void setIdwishlist(int idwishlist) {
//		this.idwishlist = idwishlist;
//	}
//
//	public Item getItem() {
//		return this.item;
//	}
//
//	public void setItem(Item item) {
//		this.item = item;
//	}
//
//	public Userinfo getUserinfo() {
//		return this.userinfo;
//	}
//
//	public void setUserinfo(Userinfo userinfo) {
//		this.userinfo = userinfo;
//	}

}