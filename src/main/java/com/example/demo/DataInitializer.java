package com.example.demo;

import com.example.demo.entity.Attribute;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductAttribute;
import com.example.demo.sevice.AttributeService;
import com.example.demo.sevice.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private AttributeService attributeService;

    @Override
    public void run(String... args) throws Exception {
        // Thêm thuộc tính
        Attribute ramAttribute = new Attribute();
        ramAttribute.setName("RAM");
        attributeService.createAttribute(ramAttribute);

        Attribute mouseAttribute = new Attribute();
        mouseAttribute.setName("Mouse Type");
        attributeService.createAttribute(mouseAttribute);

        // Thêm sản phẩm
        Product laptop = new Product();
        laptop.setName("Laptop XYZ");
        laptop.setDescription("Laptop XYZ với cấu hình mạnh mẽ.");
        laptop.setPrice(BigDecimal.valueOf(1500.00));
        laptop.setQuantity(10);
        productService.createProduct(laptop);

        Product ram = new Product();
        ram.setName("RAM 16GB");
        ram.setDescription("RAM DDR4 16GB cho hiệu suất cao.");
        ram.setPrice(BigDecimal.valueOf(100.00));
        ram.setQuantity(50);
        productService.createProduct(ram);

        // Thêm thuộc tính cho sản phẩm
        ProductAttribute laptopRam = new ProductAttribute();
        laptopRam.setProductId(laptop.getId());
        laptopRam.setAttributeId(ramAttribute.getId());
        laptopRam.setValue("16GB");
        productService.createProductAttribute(laptopRam);

        ProductAttribute ramMouse = new ProductAttribute();
        ramMouse.setProductId(ram.getId());
        ramMouse.setAttributeId(mouseAttribute.getId());
        ramMouse.setValue("Wired");
        productService.createProductAttribute(ramMouse);
    }
}
