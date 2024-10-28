package com.ecommerce.ProductManagementAPI.service;

import com.ecommerce.ProductManagementAPI.dto.ProductDTO;

import java.util.Optional;

public interface I_InventoryRepository {
    public Optional<ProductDTO> updateStockQuantity(Long id, Integer stockQuantity);
}
