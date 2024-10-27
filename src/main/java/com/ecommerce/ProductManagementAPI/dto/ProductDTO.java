package com.ecommerce.ProductManagementAPI.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    @NotBlank(message = "Product name is required.")
    @Size(max = 255, message = "Product name must be less than 255 characters.")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters.")
    private String description;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be a positive value.")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required.")
    @PositiveOrZero(message = "Stock quantity must be a non-negative value.")
    private Integer stockQuantity;

    @NotBlank(message = "Category is required.")
    @Size(max = 100, message = "Category must be less than 100 characters.")
    private String category;

    // Default constructor
    public ProductDTO() {}

    // Parameterized constructor
    public ProductDTO(String name, String description, BigDecimal price, Integer stockQuantity, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }


}

