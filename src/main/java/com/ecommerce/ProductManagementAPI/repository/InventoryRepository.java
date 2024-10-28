package com.ecommerce.ProductManagementAPI.repository;

import com.ecommerce.ProductManagementAPI.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // Additional query methods if needed
}
