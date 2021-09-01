package com.gwennies.eindopdracht.dto;

import org.springframework.web.multipart.MultipartFile;

public class AddProductDto {
    public String name; 
    public String short_description;
    public String long_description;
    public boolean sale;
    public double price;
    public int sale_discount;
    public int quantity;
    public MultipartFile files;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSale_discount() {
        return this.sale_discount;
    }

    public void setSale_discount(int sale_discount) {
        this.sale_discount = sale_discount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MultipartFile getFile() {
        return this.files;
    }

    public void setFile(MultipartFile files) {
        this.files = files;
    }


}
