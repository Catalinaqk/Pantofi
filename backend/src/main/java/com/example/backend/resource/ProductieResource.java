package com.example.backend.resource;

import com.example.backend.domain.Productie;
import com.example.backend.service.ProductieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Productie entities.
 */
@RestController
@RequestMapping("/api/productie")
public class ProductieResource {

    private final ProductieService productieService;

    @Autowired
    public ProductieResource(ProductieService productieService) {
        this.productieService = productieService;
    }

    @GetMapping
    public List<Productie> getAllProductie() {
        return productieService.findAllProductie();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productie> getProductieById(@PathVariable String id) {
        Optional<Productie> productie = productieService.findProductieById(id);
        return productie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Productie createProductie(@RequestBody Productie productie) {
        return productieService.saveProductie(productie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductieById(@PathVariable String id) {
        productieService.deleteProductieById(id);
        return ResponseEntity.noContent().build();
    }
}