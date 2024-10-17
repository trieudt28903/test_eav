package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "product_attribute")
@IdClass(ProductAttributeId.class)
@Getter
@Setter
public class ProductAttribute {
    @Id
    private Long productId;

    @Id
    private Long attributeId;

    private String value;

    @ManyToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "attributeId", insertable = false, updatable = false)
    private Attribute attribute;

    // Getters and Setters
}
