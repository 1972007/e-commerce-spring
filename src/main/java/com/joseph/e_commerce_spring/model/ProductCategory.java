package com.joseph.e_commerce_spring.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_category")
@NamedQuery(name="ProductCategory.findAll", query="SELECT p FROM ProductCategory p")
public class ProductCategory  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductCategoryPK id;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_idCategories")
	private Category category;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="item_iditem")
	private Item item;

	@Override
	public int hashCode() {
		return Objects.hash(category, id, item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ProductCategory)) {
			return false;
		}
		ProductCategory other = (ProductCategory) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(item, other.item);
	}

//	public ProductCategory() {
//	}
//
//	public ProductCategoryPK getId() {
//		return this.id;
//	}
//
//	public void setId(ProductCategoryPK id) {
//		this.id = id;
//	}
//
//	public Category getCategory() {
//		return this.category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	public Item getItem() {
//		return this.item;
//	}
//
//	public void setItem(Item item) {
//		this.item = item;
//	}

}