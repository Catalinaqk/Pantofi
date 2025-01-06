package com.example.backend.resource;

import com.example.backend.domain.Comenzi;
import com.example.backend.service.ComenziService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comenzi")
@RequiredArgsConstructor
public class ComenziResource {
    private final ComenziService comenziService;

    @PostMapping
    public ResponseEntity<Comenzi> createComenzi(@RequestBody Comenzi comenzi) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comenziService.createComenzi(comenzi));
    }

    @GetMapping
    public ResponseEntity<List<Comenzi>> getAllComenzi() {
        return ResponseEntity.ok().body(comenziService.getAllComenzi());
    }
}