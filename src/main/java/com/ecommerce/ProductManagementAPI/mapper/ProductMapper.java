package com.ecommerce.ProductManagementAPI.mapper;

import com.ecommerce.ProductManagementAPI.dto.ProductDTO;
import com.ecommerce.ProductManagementAPI.entity.Inventory;
import com.ecommerce.ProductManagementAPI.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // Convert ProductDTO to Product entity
    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        Inventory productInventory = productDTO.getInventory();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setInventory(productDTO.getInventory());
        productInventory.setProduct(product);
        return product;
    }

    // Convert Product entity to ProductDTO
    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory());
        productDTO.setInventory(product.getInventory());
        return productDTO;
    }
}
