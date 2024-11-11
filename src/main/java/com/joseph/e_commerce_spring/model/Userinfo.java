package com.joseph.e_commerce_spring.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the userinfo database table.
 *
 */
@Entity
//@NamedQuery(name="Userinfo.findAll", query="SELECT u FROM Userinfo u")
public class Userinfo  {
	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	private String address;

	private int age;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_at")
	private Date modifiedAt;

	private String name;

	private String occupation;

	private String sex;

//	//bi-directional many-to-one association to Cart
//	@OneToMany(mappedBy="userinfo")
//	private List<Cart> carts;
//
//	//bi-directional many-to-one association to Merchant
//	@OneToMany(mappedBy="userinfo")
//	private List<Merchant> merchants;

	@Override
	public int hashCode() {
		return Objects.hash(address, age, createdAt, modifiedAt, name, occupation, sex, user, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Userinfo)) {
			return false;
		}
		Userinfo other = (Userinfo) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(modifiedAt, other.modifiedAt) && Objects.equals(name, other.name)
				&& Objects.equals(occupation, other.occupation) && Objects.equals(sex, other.sex)
				&& Objects.equals(user, other.user) && Objects.equals(userId, other.userId);
	}

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="userId")
	private User user;

//	//bi-directional many-to-one association to Wishlist
//	@OneToMany(mappedBy="userinfo")
//	private List<Wishlist> wishlists;

	public Userinfo() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return this.modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

//	public List<Cart> getCarts() {
//		return this.carts;
//	}
//
//	public void setCarts(List<Cart> carts) {
//		this.carts = carts;
//	}

//	public Cart addCart(Cart cart) {
//		getCarts().add(cart);
//		cart.setUserinfo(this);
//
//		return cart;
//	}
//
//	public Cart removeCart(Cart cart) {
//		getCarts().remove(cart);
//		cart.setUserinfo(null);
//
//		return cart;
//	}

//	public List<Merchant> getMerchants() {
//		return this.merchants;
//	}
//
//	public void setMerchants(List<Merchant> merchants) {
//		this.merchants = merchants;
//	}

//	public Merchant addMerchant(Merchant merchant) {
//		getMerchants().add(merchant);
//		merchant.setUserinfo(this);
//
//		return merchant;
//	}
//
//	public Merchant removeMerchant(Merchant merchant) {
//		getMerchants().remove(merchant);
//		merchant.setUserinfo(null);
//
//		return merchant;
//	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<Wishlist> getWishlists() {
//		return this.wishlists;
//	}
//
//	public void setWishlists(List<Wishlist> wishlists) {
//		this.wishlists = wishlists;
//	}

//	public Wishlist addWishlist(Wishlist wishlist) {
//		getWishlists().add(wishlist);
//		wishlist.setUserinfo(this);
//
//		return wishlist;
//	}
//
//	public Wishlist removeWishlist(Wishlist wishlist) {
//		getWishlists().remove(wishlist);
//		wishlist.setUserinfo(null);
//
//		return wishlist;
//	}

}