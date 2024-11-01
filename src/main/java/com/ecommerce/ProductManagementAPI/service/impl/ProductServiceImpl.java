package com.ecommerce.ProductManagementAPI.service.impl;


import com.ecommerce.ProductManagementAPI.dto.ProductDTO;
import com.ecommerce.ProductManagementAPI.entity.Product;
import com.ecommerce.ProductManagementAPI.exception.ProductAlreadyExistsException;
import com.ecommerce.ProductManagementAPI.exception.ResourceNotFoundException;
import com.ecommerce.ProductManagementAPI.mapper.ProductMapper;
import com.ecommerce.ProductManagementAPI.policy.ProductPolicy;
import com.ecommerce.ProductManagementAPI.repository.ProductRepository;
import com.ecommerce.ProductManagementAPI.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductPolicy productPolicy;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,ProductPolicy productPolicy) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productPolicy = productPolicy;
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        productPolicy.validateProduct(productDTO);
        if (!isProductNameUnique(productDTO.getName())) {
            throw new ProductAlreadyExistsException("Product with name '" + productDTO.getName() + "' already exists.");
        }

        Product product = productMapper.toEntity(productDTO);
        product.setCreatedAt(LocalDateTime.now());
        product.setCreatedBy("CreatedByAdmin");
        product.getInventory().setCreatedBy("CreatedByAdmin");
        product.getInventory().setCreatedAt(LocalDateTime.now());

        product= productRepository.save(product);

        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with the given input data", "id", id.toString()));
        ProductDTO productDTO = productMapper.toDTO(product);
        return productDTO;

    }

    @Override
    public List<ProductDTO> getAllProducts(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable).getContent().stream().map(ProductMapper::toDTO).toList();
    }

    @Override
    public boolean updateProduct(Long id, ProductDTO productDTO) {
        productPolicy.validateProduct(productDTO);
        boolean isUpdated=false;
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with the given input data", "id", id.toString()));

        // Check if another product with the same name already exists
        if (!isProductNameUnique(productDTO.getName()) && !product.getName().equals(productDTO.getName())) {
            throw new ProductAlreadyExistsException("Product with name '" + productDTO.getName() + "' already exists.");
        }
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setProductId(id);
        product.setUpdatedAt(LocalDateTime.now());
        product.setUpdatedBy("ShopKeeper");
        product.getInventory().setStockQuantity(productDTO.getInventory().getStockQuantity());
        product.getInventory().setUpdatedBy("ShopKeeper");
        product.getInventory().setUpdatedAt(LocalDateTime.now());

       productRepository.save(product);

        isUpdated=true;

        return isUpdated;
    }


    @Override
    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found", "id", id.toString()));
        productRepository.delete(product);
        return true;
    }

    @Override
    public Optional<ProductDTO> updateStockQuantity(Long id, Integer stockQuantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found", "id", id.toString()));
        product.getInventory().setStockQuantity(stockQuantity);
        product.getInventory().setUpdatedBy("ShopKeeper");
        product.getInventory().setUpdatedAt(LocalDateTime.now());
        productRepository.save(product);
        return Optional.of(ProductMapper.toDTO(product));
    }

    @Override
    public boolean isProductNameUnique(String name) {
        return productRepository.findByName(name).isEmpty();
    }
}

