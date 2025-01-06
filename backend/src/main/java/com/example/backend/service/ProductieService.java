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

    public Productie getProductieById(Long id) {
        return productieRepo.findProductieByIdProductie(id).orElseThrow(() -> new RuntimeException("Productie nu a fost gasita"));
    }

    public List<Productie> getAllProductie() {
        return productieRepo.findAll();
    }

    public void deleteProductie(Long id) {
        productieRepo.deleteById(id);
    }

    public Productie createProductie(Productie productie) {
        return productieRepo.save(productie);
    }

    public Productie updateProductie(Productie productie) {
        return productieRepo.save(productie);
    }
}