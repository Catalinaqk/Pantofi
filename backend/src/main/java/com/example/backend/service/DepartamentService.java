package com.example.backend.service;


import com.example.backend.repo.DepartamenteRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.backend.domain.Departamente;


@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor

public class DepartamentService {
    private final DepartamenteRepo departamenteRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Departamente getDepartamenteById(String id) {
        return departamenteRepo.findDepartamenteById(id).orElseThrow(() -> new RuntimeException("Departamente not found"));
    }

    public Departamente getDepartamenteByNume(String nume) {
        return departamenteRepo.findDepartamenteByName(nume).orElseThrow(() -> new RuntimeException("Departamente not found"));
    }

    public Departamente loginDepartamente(Departamente departamente){
        Departamente foundDepartamente = departamenteRepo.findDepartamenteByName(departamente.getName())
                .orElseThrow(() -> new RuntimeException("Invalid nume"));
        if(bCryptPasswordEncoder.matches(departamente.getPassword(), foundDepartamente.getPassword())){
            return foundDepartamente;
        } else {
            throw new RuntimeException("Invalid parola");
        }
    }

    public Departamente createDepartamente(Departamente departamente) {
        if(departamenteRepo.findDepartamenteByName(departamente.getName()).isPresent()){
            throw new RuntimeException("Nume already exists");
        }
        departamente.setPassword(bCryptPasswordEncoder.encode(departamente.getPassword()));
        return departamenteRepo.save(departamente);
    }

    public Departamente updateDepartamente(Departamente departamente) {
        return departamenteRepo.save(departamente);
    }

    public void deleteDepartamente(String id) {
        departamenteRepo.deleteById(Long.valueOf(id));
    }

}
