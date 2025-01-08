package com.example.backend.resource;

import com.example.backend.domain.Materiale;
import com.example.backend.service.MaterialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiale")
public class    MaterialeResource {

    private final MaterialeService materialeService;

    @Autowired
    public MaterialeResource(MaterialeService materialeService) {
        this.materialeService = materialeService;
    }

    @GetMapping
    public List<Materiale> getAllMateriale() {
        return materialeService.findAllMateriale();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materiale> getMaterialeById(@PathVariable String id) {
        Optional<Materiale> materiale = materialeService.findMaterialeById(id);
        return materiale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Materiale createMateriale(@RequestBody Materiale materiale) {
        return materialeService.saveMateriale(materiale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterialeById(@PathVariable String id) {
        materialeService.deleteMaterialeById(id);
        return ResponseEntity.noContent().build();
    }
}