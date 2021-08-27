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

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

	@Column(length = 45, nullable = false)
	@Size(max = 45, message = "Name must be maximum of 45 characters.")
	@NotBlank(message = "Name cannot be blank.")
	String name;
    
    @Column
    private String short_description;
    private String long_description;
    private boolean sale;

	@NotNull
	@ColumnDefault("0")
	@Max(value = 999999999, message= "Invalid quantity.")
	@Min(value = 0, message= "Quantity should be 0 or higher.")
	int quantity;

    @NotNull
    @ColumnDefault("0")
    @Max(value = 100, message= "Invalid number")
    @Min(value = 0, message="discount should be 0 or higher")
    int sale_discount;

    @NotNull
	@ColumnDefault("0")
    @Min(value = 0, message= "Quantity should be 0 or higher.")
    private double price;

    @Column(nullable = true, length = 64)
    private String photos;

    public Product() {
		super();
	}

	public Product(String name, String shortDescription, String longDescription, double price, int quantity, boolean sale, int saleDiscount) {
		super();
		this.name = name;
		this.quantity = quantity;
        this.short_description = shortDescription;
        this.long_description = longDescription;
        this.price = price;
        this.sale = sale;
        this.sale_discount = saleDiscount;
    }

    public String getShort_description() {
        return this.short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return this.long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public boolean isSale() {
        return this.sale;
    }

    public boolean getSale() {
        return this.sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public int getSaleDiscount() {
        return this.sale_discount;
    }

    public void setSaleDiscount(int saleDiscount) {
        this.sale_discount = saleDiscount;
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

    public String getProductPicture() {
        return photos;
    }

    public void setProductPicture(String photos) {
        this.photos= photos;
    }
}


