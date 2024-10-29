package com.ecommerce.ProductManagementAPI.mapper;

import com.ecommerce.ProductManagementAPI.dto.ProductDTO;
import com.ecommerce.ProductManagementAPI.entity.Inventory;
import com.ecommerce.ProductManagementAPI.entity.Product;
import com.ecommerce.ProductManagementAPI.entity.ProductDiscount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    // Convert ProductDTO to Product entity
    public static Product toEntity(ProductDTO productDTO, Product product) {

        if(isEmpty(product))
        {
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setCategory(productDTO.getCategory());
            product.setInventory(productDTO.getInventory());
            product.setProductDiscounts(productDTO.getProductDiscounts());
        }
        else {
            product.setName(product.getName());
            product.setDescription(product.getDescription());
            product.setPrice(product.getPrice());
            product.setCategory(product.getCategory());
            product.setInventory(product.getInventory());
            product.setProductDiscounts(product.getProductDiscounts());
        }
        return product;
    }

    // Convert Product entity to ProductDTO
    public static ProductDTO toDTO(Product product, ProductDTO productDTO) {
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory());
        productDTO.setInventory(product.getInventory());
        productDTO.setProductDiscounts(product.getProductDiscounts());
        return productDTO;
    }

    public static boolean isEmpty(Product product) {
        return (product.getName() == null || product.getName().isEmpty()) &&
                (product.getDescription() == null || product.getDescription().isEmpty()) &&
                product.getPrice() == null &&
                (product.getCategory() == null || product.getCategory().isEmpty()) &&
                product.getInventory() == null &&
                (product.getProductDiscounts() == null || product.getProductDiscounts().isEmpty());
    }

}
