package com.example.demo.sevice;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductAttribute;
import com.example.demo.repository.ProductAttributeRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    public List<ProductAttribute> getAttributesByProductId(Long productId) {
        return productAttributeRepository.findAll().stream()
                .filter(attr -> attr.getProductId().equals(productId))
                .toList();
    }
}

