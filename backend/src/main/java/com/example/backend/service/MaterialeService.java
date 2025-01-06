package com.example.backend.service;

import com.example.backend.domain.Materiale;
import com.example.backend.repo.MaterialeRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class MaterialeService {
    private final MaterialeRepo materialeRepo;

    public Materiale getMaterialeById(Long id) {
        return materialeRepo.findById(id).orElseThrow(() -> new RuntimeException("Material not found"));
    }

    public List<Materiale> getAllMateriale() {
        return materialeRepo.findAll();
    }

    public Materiale createMateriale(Materiale materiale) {
        return materialeRepo.save(materiale);
    }

    public Materiale updateMateriale(Materiale materiale) {
        return materialeRepo.save(materiale);
    }

    public void deleteMateriale(Long id) {
        materialeRepo.deleteById(id);
    }
}