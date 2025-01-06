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
@RequestMapping("/productie")
@RequiredArgsConstructor
public class ProductieResource {
    private final ProductieService productieService;

    /**
     * Creates a new productie.
     *
     * @param productie the productie to create.
     * @return the ResponseEntity with status 201 (Created) and with body the new productie.
     */
    @PostMapping
    public ResponseEntity<Productie> createProductie(@RequestBody Productie productie) {
        return ResponseEntity.created(URI.create("/productie/productieID")).body(productieService.createProductie(productie));
    }

    /**
     * Gets all productie.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of productie in body.
     */
    @GetMapping
    public ResponseEntity<List<Productie>> getProductie() {
        return ResponseEntity.ok().body(productieService.getAllProductie());
    }

    /**
     * Gets a productie by its unique identifier.
     *
     * @param id the unique identifier of the productie.
     * @return the ResponseEntity with status 200 (OK) and with body the productie.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Productie> getProductieById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(productieService.getProductieById(id));
    }

    /**
     * Gets an author by their name.
     *
     * @param name the name of the author.
     * @return the ResponseEntity with status 200 (OK) and with body the author.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Productie> getProductieByName(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok().body(productieService.getProductieByName(name));
    }

    /**
     * Deletes a productie by its unique identifier.
     *
     * @param id the unique identifier of the productie.
     * @return the ResponseEntity with status 200 (OK).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductie(@PathVariable(value = "id") String id) {
        productieService.deleteProductie(id);
        return ResponseEntity.ok().build();
    }
}