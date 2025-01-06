package com.example.backend.resource;

import com.example.backend.domain.Productie;
import com.example.backend.service.ProductieService;
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
public class ProductieResource {
    private final ProductieService productieService;

    @PostMapping
    public ResponseEntity<Productie> createProductie(@RequestBody Productie productie) {
        return ResponseEntity.created(URI.create("/productie/productieID")).body(productieService.createProductie(productie));
    }

    @GetMapping
    public ResponseEntity<List<Productie>> getProductie() {
        return ResponseEntity.ok().body(productieService.getAllProductie());
    }

    @DeleteMapping("/{idProductie}")
    public ResponseEntity<Void> deleteProductie(@PathVariable(value = "idProductie") Long idProductie) {
        productieService.deleteProductie(idProductie);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Productie> updateProductie(@RequestBody Productie productie) {
        return ResponseEntity.ok().body(productieService.updateProductie(productie));
    }


}