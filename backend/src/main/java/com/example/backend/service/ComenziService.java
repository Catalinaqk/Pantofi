package com.example.backend.service;

import com.example.backend.domain.Comenzi;
import com.example.backend.repo.ComenziRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Comenzi entities.
 */
@Service
public class ComenziService {

    private final ComenziRepo comenziRepo;

    @Autowired
    public ComenziService(ComenziRepo comenziRepo) {
        this.comenziRepo = comenziRepo;
    }

    public List<Comenzi> findAllComenzi() {
        return comenziRepo.findAll();
    }

    public Optional<Comenzi> findComenziById(String id) {
        return comenziRepo.findComenziById(id);
    }

    public Optional<Comenzi> findComenziByNume(String nume) {
        return comenziRepo.findComenziByNume(nume);
    }

    public Comenzi saveComenzi(Comenzi comenzi) {
        return comenziRepo.save(comenzi);
    }

    public void deleteComenziById(String id) {
        comenziRepo.deleteById(id);
    }
}