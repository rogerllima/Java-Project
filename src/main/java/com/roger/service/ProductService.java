package com.roger.service;

import com.roger.domain.product.Product;
import com.roger.domain.product.ProductRepository;
import com.roger.domain.product.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ResponseEntity getAllProducts() {
        List<Product> allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    public ResponseEntity registerProduct(RequestProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity updateProduct(RequestProduct data) {
        Optional<Product> optionalProduct = repository.findById(data.getId());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            return ResponseEntity.ok(product);

        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity deleteProduct(UUID id){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
