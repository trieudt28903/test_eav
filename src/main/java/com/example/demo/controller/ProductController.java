package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductAttribute;
import com.example.demo.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productId}/attributes")
    public ResponseEntity<ProductAttribute> createProductAttribute(@PathVariable Long productId, @RequestBody ProductAttribute productAttribute) {
        productAttribute.setProductId(productId);
        return new ResponseEntity<>(productService.createProductAttribute(productAttribute), HttpStatus.CREATED);
    }

    @GetMapping("/{productId}/attributes")
    public ResponseEntity<List<ProductAttribute>> getAttributesByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getAttributesByProductId(productId));
    }
}
