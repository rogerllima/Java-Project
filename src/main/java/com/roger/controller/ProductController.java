package com.roger.controller;

import com.roger.domain.product.ProductRepository;
import com.roger.domain.product.RequestProduct;
import com.roger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody RequestProduct data) {
        return service.registerProduct(data);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity updateProduct(@RequestBody RequestProduct data) {
        return service.updateProduct(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable UUID id) {
        return service.deleteProduct(id);
    }
}
