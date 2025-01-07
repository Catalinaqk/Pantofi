package com.example.backend.service;

import com.example.backend.domain.Materiale;
import com.example.backend.repo.MaterialeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialeService {

    private final MaterialeRepo materialeRepo;

    @Autowired
    public MaterialeService(MaterialeRepo materialeRepo) {
        this.materialeRepo = materialeRepo;
    }

    public List<Materiale> findAllMateriale() {
        return materialeRepo.findAll();
    }

    public Optional<Materiale> findMaterialeById(String id) {
        return materialeRepo.findMaterialeById(id);
    }

    public Optional<Materiale> findMaterialeByNume(String nume) {
        return materialeRepo.findMaterialeByNume(nume);
    }

    public Materiale saveMateriale(Materiale materiale) {
        return materialeRepo.save(materiale);
    }

    public void deleteMaterialeById(String id) {
        materialeRepo.deleteById(id);
    }
}