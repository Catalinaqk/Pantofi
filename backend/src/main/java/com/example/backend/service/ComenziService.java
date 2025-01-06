package com.example.backend.service;

import com.example.backend.domain.Comenzi;
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

    /**
     * Gets a comenzi by its unique identifier.
     *
     * @param id the unique identifier of the comenzi.
     * @return the found comenzi.
     * @throws RuntimeException if the comenzi is not found.
     */
    public Comenzi getComenziById(Long id){
        return comenziRepo.findComenziById(id).orElseThrow(() -> new RuntimeException("Comenzi not found"));
    }

    /**
     * Gets all comenzi.
     *
     * @return the list of all comenzi.
     */
    public List<Comenzi> getAllComenzi() {
        return comenziRepo.findAll();
    }

    /**
     * Creates a new comenzi.
     *
     * @param comenzi the comenzi to create.
     * @return the created comenzi.
     */
    public Comenzi createComenzi(Comenzi comenzi) {
        return comenziRepo.save(comenzi);
    }

    /**
     * Updates a comenzi.
     *
     * @param comenzi the comenzi to update.
     * @return the updated comenzi.
     */
    public Comenzi updateComenzi(Comenzi comenzi) {
        return comenziRepo.save(comenzi);
    }

}