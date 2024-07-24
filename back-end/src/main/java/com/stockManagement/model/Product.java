package com.stockManagement.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="products")
public class Product {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "product_id")
	private String  productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private int productPrice;
	
	@Column(name = "count")
	private int productCount;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name ="product_images",
			joinColumns = {
					@JoinColumn(name ="product_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name= "image_id")
			}
			)
	private Set<ImageModel> productImages; 
	
	
	
	public Set<ImageModel> getProductImages() {
		return productImages;
	}


	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages = productImages;
	}

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(String productType, String productId, String productName, int productPrice, int productCount) {
		super();
		this.productType = productType;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
	}


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	

	
}
