package com.example.backend.resource;

import com.example.backend.domain.Comenzi;
import com.example.backend.service.ComenziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Comenzi entities.
 */
@RestController
@RequestMapping("/api/comenzi")
public class ComenziResource {

    private final ComenziService comenziService;

    @Autowired
    public ComenziResource(ComenziService comenziService) {
        this.comenziService = comenziService;
    }

    @GetMapping
    public List<Comenzi> getAllComenzi() {
        return comenziService.findAllComenzi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comenzi> getComenziById(@PathVariable String id) {
        Optional<Comenzi> comenzi = comenziService.findComenziById(id);
        return comenzi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Comenzi createComenzi(@RequestBody Comenzi comenzi) {
        return comenziService.saveComenzi(comenzi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComenziById(@PathVariable String id) {
        comenziService.deleteComenziById(id);
        return ResponseEntity.noContent().build();
    }
}