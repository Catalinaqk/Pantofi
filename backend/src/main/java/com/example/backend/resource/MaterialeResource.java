package com.example.backend.resource;

import com.example.backend.domain.Materiale;
import com.example.backend.service.MaterialeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mentenante")
@RequiredArgsConstructor
public class MaterialeResource {
    private final MaterialeService materialeService;

    @PostMapping
    public ResponseEntity<Materiale> createMateriale(@RequestBody Materiale materiale) {
        return ResponseEntity.created(URI.create("/materiale/materialeID")).body(materialeService.createMateriale(materiale));
    }

    @GetMapping
    public ResponseEntity<List<Materiale>> getMateriale() {
        return ResponseEntity.ok().body(materialeService.getAllMateriale());
    }

    @DeleteMapping("/{idMateriale}")
    public ResponseEntity<Void> deleteMateriale(@PathVariable(value = "idMateriale") Long idMateriale) {
        materialeService.deleteMateriale(idMateriale);
        return ResponseEntity.noContent().build();
    }
}
