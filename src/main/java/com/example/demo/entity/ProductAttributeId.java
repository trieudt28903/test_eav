package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductAttributeId implements Serializable {
    private Long productId;
    private Long attributeId;

    // Default constructor
    public ProductAttributeId() {}

    // Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductAttributeId)) return false;
        ProductAttributeId that = (ProductAttributeId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(attributeId, that.attributeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, attributeId);
    }
}

