package com.ecommerce.ProductManagementAPI.dto;


import com.ecommerce.ProductManagementAPI.entity.Inventory;
import com.ecommerce.ProductManagementAPI.entity.ProductDiscount;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Product name is required.")
    @Size(max = 255, message = "Product name must be less than 255 characters.")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters.")
    private String description;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be a positive value.")
    private BigDecimal price;


    @NotBlank(message = "Category is required.")
    @Size(max = 100, message = "Category must be less than 100 characters.")
    private String category;


    @NotNull(message = "Inventory is required.")
    private Inventory inventory;

    @NotNull(message = "productDiscounts is required.")
    private List<ProductDiscount> productDiscounts;

    public ProductDTO() {}



}

