package com.ecommerce.ProductManagementAPI.service.impl;

import com.ecommerce.ProductManagementAPI.dto.ProductDTO;
import com.ecommerce.ProductManagementAPI.service.I_InventoryRepository;

import java.util.Optional;

public class InventoryRepositoryService implements I_InventoryRepository {
    @Override
    public Optional<ProductDTO> updateStockQuantity(Long id, Integer stockQuantity) {
        return Optional.empty();
    }
}
