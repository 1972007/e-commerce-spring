package com.joseph.e_commerce_spring.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the item database table.
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item  {
	private static final long serialVersionUID = 1L;

	@Id
	private int iditem;

	private String desc;

	@Column(name="image_link")
	private String imageLink;

	private String name;

	private BigDecimal price;

//	//bi-directional many-to-one association to Cart
//	@OneToMany(mappedBy="item")
//	private List<Cart> carts;
//
//	//bi-directional many-to-one association to Cart
//	@ManyToOne
//	@JoinColumn(name="iditem", referencedColumnName="product_iditem")
//	private Cart cart;
//
//	//bi-directional many-to-one association to Merchant
//	@ManyToOne
//	private Merchant merchant;
//
//	//bi-directional many-to-one association to ProductCategory
//	@OneToMany(mappedBy="item")
//	private List<ProductCategory> productCategories;
//
//	//bi-directional many-to-one association to Wishlist
//	@OneToMany(mappedBy="item")
//	private List<Wishlist> wishlists;

	@Override
	public int hashCode() {
		return Objects.hash(desc, iditem, imageLink, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		return Objects.equals(desc, other.desc) && iditem == other.iditem && Objects.equals(imageLink, other.imageLink)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

//	public Item() {
//	}
//
//	public int getIditem() {
//		return this.iditem;
//	}
//
//	public void setIditem(int iditem) {
//		this.iditem = iditem;
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
//	public String getImageLink() {
//		return this.imageLink;
//	}
//
//	public void setImageLink(String imageLink) {
//		this.imageLink = imageLink;
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
//	public BigDecimal getPrice() {
//		return this.price;
//	}
//
//	public void setPrice(BigDecimal price) {
//		this.price = price;
//	}

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
//		cart.setItem(this);
//
//		return cart;
//	}
//
//	public Cart removeCart(Cart cart) {
//		getCarts().remove(cart);
//		cart.setItem(null);
//
//		return cart;
//	}
//
//	public Cart getCart() {
//		return this.cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	public Merchant getMerchant() {
//		return this.merchant;
//	}
//
//	public void setMerchant(Merchant merchant) {
//		this.merchant = merchant;
//	}
//
//	public List<ProductCategory> getProductCategories() {
//		return this.productCategories;
//	}
//
//	public void setProductCategories(List<ProductCategory> productCategories) {
//		this.productCategories = productCategories;
//	}
//
//	public ProductCategory addProductCategory(ProductCategory productCategory) {
//		getProductCategories().add(productCategory);
//		productCategory.setItem(this);
//
//		return productCategory;
//	}
//
//	public ProductCategory removeProductCategory(ProductCategory productCategory) {
//		getProductCategories().remove(productCategory);
//		productCategory.setItem(null);
//
//		return productCategory;
//	}
//
//	public List<Wishlist> getWishlists() {
//		return this.wishlists;
//	}
//
//	public void setWishlists(List<Wishlist> wishlists) {
//		this.wishlists = wishlists;
//	}
//
//	public Wishlist addWishlist(Wishlist wishlist) {
//		getWishlists().add(wishlist);
//		wishlist.setItem(this);
//
//		return wishlist;
//	}
//
//	public Wishlist removeWishlist(Wishlist wishlist) {
//		getWishlists().remove(wishlist);
//		wishlist.setItem(null);
//
//		return wishlist;
//	}

}