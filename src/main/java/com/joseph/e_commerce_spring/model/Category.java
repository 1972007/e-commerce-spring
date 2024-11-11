package com.joseph.e_commerce_spring.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the category database table.
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category  {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCategories;

	private String desc;

	private String categoryName;
//	//bi-directional many-to-one association to ProductCategory
//	@OneToMany(mappedBy="category")
//	private List<ProductCategory> productCategories;

	@Override
	public int hashCode() {
		return Objects.hash(categoryName, desc, idCategories);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
		return Objects.equals(categoryName, other.categoryName) && Objects.equals(desc, other.desc)
				&& idCategories == other.idCategories;
	}



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
//		productCategory.setCategory(this);
//
//		return productCategory;
//	}
//
//	public ProductCategory removeProductCategory(ProductCategory productCategory) {
//		getProductCategories().remove(productCategory);
//		productCategory.setCategory(null);
//
//		return productCategory;
//	}

}