package com.ecommerce.ProductManagementAPI.service;

import com.ecommerce.ProductManagementAPI.dto.ProductDTO;
import com.ecommerce.ProductManagementAPI.entity.Product;

import java.util.List;

public interface IProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProducts(int page, int size, String sortBy, String sortDirection);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);

    ProductDTO updateStockQuantity(Long id, Integer stockQuantity);

    boolean isProductNameUnique(String name);
}
