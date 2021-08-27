package com.gwennies.eindopdracht.dto;

import org.springframework.web.multipart.MultipartFile;

public class AddProductDto {
    public String name; 
    public MultipartFile file;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return this.file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
