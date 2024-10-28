package com.ecommerce.ProductManagementAPI.policy;

import com.ecommerce.ProductManagementAPI.dto.ProductDTO;
import com.ecommerce.ProductManagementAPI.exception.InvalidPriceException;
import com.ecommerce.ProductManagementAPI.exception.InvalidStockException;
import com.ecommerce.ProductManagementAPI.exception.ProductAlreadyExistsException;
import com.ecommerce.ProductManagementAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPolicy {

    public void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPriceException("Price must be a positive value.");
        }
    }

    public void validateStockQuantity(Integer stockQuantity) {
        if (stockQuantity == null || stockQuantity < 0) {
            throw new InvalidStockException("Stock quantity must be a non-negative integer.");
        }
    }
    public void validateProduct(ProductDTO productDTO) {
        validatePrice(productDTO.getPrice());
        validateStockQuantity(productDTO.getStockQuantity());
    }
}
