package com.joseph.e_commerce_spring.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the product_category database table.
 * 
 */
@Embeddable
public class ProductCategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int category_idCategories;

	@Column(name="item_iditem", insertable=false, updatable=false)
	private int itemIditem;

	public ProductCategoryPK() {
	}
	public int getCategory_idCategories() {
		return this.category_idCategories;
	}
	public void setCategory_idCategories(int category_idCategories) {
		this.category_idCategories = category_idCategories;
	}
	public int getItemIditem() {
		return this.itemIditem;
	}
	public void setItemIditem(int itemIditem) {
		this.itemIditem = itemIditem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductCategoryPK)) {
			return false;
		}
		ProductCategoryPK castOther = (ProductCategoryPK)other;
		return 
			(this.category_idCategories == castOther.category_idCategories)
			&& (this.itemIditem == castOther.itemIditem);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.category_idCategories;
		hash = hash * prime + this.itemIditem;
		
		return hash;
	}
}