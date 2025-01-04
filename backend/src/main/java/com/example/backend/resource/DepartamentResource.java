package com.example.backend.resource;


import com.example.backend.domain.Departamente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.DepartamentService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;


@Slf4j
@RestController
@RequestMapping("/departamente")
@RequiredArgsConstructor

public class DepartamentResource {
    private final DepartamentService departamentService;

    @PostMapping("/register")
    public ResponseEntity<Departamente> createDepartamente(@RequestBody Departamente departament){
        try {
            return ResponseEntity.created(URI.create("/departamente/departamentID")).body(departamentService.createDepartamente(departament));
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(null); // 409 Conflict
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Departamente> loginDepartament(@RequestBody Departamente departament){
        try{
            Departamente foundDepartament = departamentService.loginDepartamente(departament);
            return ResponseEntity.ok().body(foundDepartament);
        } catch (RuntimeException e){
            return ResponseEntity.status(401).body(null);
        }
    }
}
