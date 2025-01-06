package com.example.backend.service;

import com.example.backend.domain.Productie;
import com.example.backend.repo.ProductieRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ProductieService {
    private final ProductieRepo productieRepo;

    /**
     * Gets an productie by its name.
     *
     * @param name the name of the productie.
     * @return the found productie.
     * @throws RuntimeException if the productie is not found.
     */
    public Productie getProductieByName(String name) {
        return productieRepo.findProductieByName(name).orElseThrow(() -> new RuntimeException("Productie not found"));
    }

    /**
     * Gets all productie.
     *
     * @return the list of all productie.
     */
    public List<Productie> getAllProductie() {
        return productieRepo.findAll();
    }

    /**
     * Gets an productie by its unique identifier.
     *
     * @param id the unique identifier of the productie.
     * @return the found productie.
     * @throws RuntimeException if the productie is not found.
     */
    public Productie getProductieById(String id) {
        return productieRepo.findProductieById(id).orElseThrow(() -> new RuntimeException("Productie not found"));
    }

    /**
     * Creates a new productie.
     *
     * @param productie the productie to create.
     * @return the created productie.
     */
    public Productie createProductie(Productie productie) {
        return productieRepo.save(productie);
    }

    /**
     * Deletes a productie by its unique identifier.
     *
     * @param id the unique identifier of the productie.
     */
    public void deleteProductie(String id) {
        productieRepo.deleteById(id);
    }
}