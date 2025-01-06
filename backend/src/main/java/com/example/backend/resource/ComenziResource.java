package com.example.backend.resource;

import com.example.backend.domain.Comenzi;
import com.example.backend.service.ComenziService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comenzi")
@RequiredArgsConstructor
public class ComenziResource {
    private final ComenziService comenziService;

    /**
     * Creates a new comenzi.
     *
     * @param comenzi the comenzi to create.
     * @return the ResponseEntity with status 201 (Created) and with body the new comenzi.
     */
    @PostMapping
    public ResponseEntity<Comenzi> createComenzi(@RequestBody Comenzi comenzi){
        return ResponseEntity.created(URI.create("/comenzi/comenziID")).body(comenziService.createComenzi(comenzi));
    }

    /**
     * Gets all comenzi.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of comenzi in body.
     */
    @GetMapping
    public ResponseEntity<List<Comenzi>> getComenzi(){
        return ResponseEntity.ok().body(comenziService.getAllComenzi());
    }

    /**
     * Gets a comenzi by its unique identifier.
     *
     * @param id the unique identifier of the comenzi.
     * @return the ResponseEntity with status 200 (OK) and with body the comenzi.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Comenzi> getComenziById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(comenziService.getComenziById(id));
    }


}