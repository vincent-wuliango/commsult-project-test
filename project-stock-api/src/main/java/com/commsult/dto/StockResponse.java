package com.commsult.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StockResponse {
    
    private Long id;

    @NotEmpty(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Quantity is required")
    private Long quantity;

    @NotNull(message = "Price is required")
    private Double price;

    private String description;

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
