package com.example.backend.service;

import com.example.backend.domain.Productie;
import com.example.backend.repo.ProductieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Productie entities.
 */
@Service
public class ProductieService {

    private final ProductieRepo productieRepo;

    @Autowired
    public ProductieService(ProductieRepo productieRepo) {
        this.productieRepo = productieRepo;
    }

    public List<Productie> findAllProductie() {
        return productieRepo.findAll();
    }

    public Optional<Productie> findProductieById(String id) {
        return productieRepo.findProductieById(id);
    }

    public Optional<Productie> findProductieByNumeLucrator(String numeLucrator) {
        return productieRepo.findProductieByNumeLucrator(numeLucrator);
    }

    public Productie saveProductie(Productie productie) {
        return productieRepo.save(productie);
    }

    public void deleteProductieById(String id) {
        productieRepo.deleteById(id);
    }
}