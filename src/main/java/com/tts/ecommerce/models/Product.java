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

    private String price;

    private String description;

    private String image;

    
	public Product() {
	}

	public Product(Long id, String name, int quantity, String category, String brand, String price, String description,
			String image) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.image = image;
	}


    public Product(int i, float f, String string, String string2, String string3, String string4, String string5) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
                + ", name=" + name + ", price=" + price + "]";
    }






    
    

    

    

    
}
