package com.ecommerce.ProductManagementAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @Column(nullable = false)
    private Integer stockQuantity;

    // One-to-One relationship back to Product
    @OneToOne  // Ensures that Inventory is required/ Defines foreign key
    @JoinColumn(name = "product_id", nullable = false)
    @JsonBackReference
    private Product product;

}
