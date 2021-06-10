package com.gwennies.eindopdracht.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(length = 45, nullable = false)
	@Size(max = 45, message = "Name must be maximum of 45 characters.")
	@NotBlank(message = "Name cannot be blank.")
	String name;
    
    @Column
    private String short_description;
    private String long_description;

	@NotNull
	@ColumnDefault("0")
	@Max(value = 999999999, message= "Invalid quantity.")
	@Min(value = 0, message= "Quantity should be 0 or higher.")
	int quantity;

    @NotNull
	@ColumnDefault("0")
    @Min(value = 0, message= "Quantity should be 0 or higher.")
    private double price;

    public Product() {
		super();
	}

	public Product(String name, String shortDescription, String longDescription, double price, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
        this.short_description = shortDescription;
        this.long_description = longDescription;
        this.price = price;
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShortDescription() {
        return this.short_description;
    }

    public void setShortDescription(String shortDescription) {
        this.short_description = shortDescription;
    }

    public String getLongDescription() {
        return this.long_description;
    }

    public void setLongDescription(String longDescription) {
        this.long_description = longDescription;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


