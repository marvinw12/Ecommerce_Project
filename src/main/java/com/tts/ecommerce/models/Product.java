package com.tts.ecommerce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int quantity;
    
    private String category;

    private String brand;

    private Float price;

    private String description;

    private String image;

    
	public Product() {
	}

    public Product(int quantity, Float price, String name, String description, String brand, String category,
    String image) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.image = image;
        }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [brand=" + brand + ", category=" + category + ", description=" + description + ", id=" + id
				+ ", image=" + image + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
    

        













    
    

    

    

    
}
