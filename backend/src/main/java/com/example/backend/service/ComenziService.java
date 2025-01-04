package com.example.backend.service;


import com.example.backend.repo.ComenziRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.backend.domain.Comenzi;


import java.util.List;


@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor


public class ComenziService {
    private final ComenziRepo comenziRepo;

    /**
     * Gets an comenzi by their name.
     *
     * @param departament the name of the comenzi.
     * @return the found comenzi.
     * @throws RuntimeException if the comenzi is not found.
     */
    public Comenzi getComenziByDepartament(String departament) {
        return comenziRepo.findComenziByDepartament(departament).orElseThrow(() -> new RuntimeException("Comenzi not found"));
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
     * Gets an comenzi by their unique identifier.
     *
     * @param id the unique identifier of the comenzi.
     * @return the found comenzi.
     * @throws RuntimeException if the comenzi is not found.
     */
    public Comenzi getComenziById(String id) {
        return comenziRepo.findComenziById(id).orElseThrow(() -> new RuntimeException("Comenzi not found"));
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
     * Deletes an comenzi by their unique identifier.
     *
     * @param id the unique identifier of the comenzi.
     */
    public void deleteComenzi(String id) {
        comenziRepo.deleteById(Long.valueOf(id));
    }
}
