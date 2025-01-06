package com.example.backend.service;

import com.example.backend.domain.Comenzi;
import com.example.backend.domain.Materiale;
import com.example.backend.repo.ComenziRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class ComenziService {
    private final ComenziRepo comenziRepo;
    private final MaterialeService materialeService;

    public Comenzi createComenzi(Comenzi comenzi) {
        Long materialeId = comenzi.getMateriale().getId();
        Materiale materiale = materialeService.getMaterialeById(materialeId);
        if (materiale.getCantitate() < comenzi.getCantitate()) {
            throw new RuntimeException("Insufficient stock");
        }
        materiale.setCantitate(materiale.getCantitate() - comenzi.getCantitate());
        materialeService.updateMateriale(materiale);
        return comenziRepo.save(comenzi);
    }

    public List<Comenzi> getAllComenzi() {
        return comenziRepo.findAll();
    }
}