package com.example.backend.resource;

import com.example.backend.domain.Materiale;
import com.example.backend.service.MaterialeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.example.backend.constant.Constant.PHOTO_DIR;
import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;

@Slf4j
@RestController
@RequestMapping("/mentenante")
@RequiredArgsConstructor
public class MaterialeResource {
    private final MaterialeService materialeService;

    /**
     * Creates a new material.
     *
     * @param materiale the material to create.
     * @return the ResponseEntity with status 201 (Created) and with body the new material.
     */
    @PostMapping
    public ResponseEntity<Materiale> createMateriale(@RequestBody Materiale materiale) {
        return ResponseEntity.created(URI.create("/mentenante/materialeID")).body(materialeService.createMateriale(materiale));
    }

    /**
     * Gets all materials with pagination.
     *
     * @param page the page number to retrieve.
     * @param size the size of the material per page.
     * @return the ResponseEntity with status 200 (OK) and the list of materials in body.
     */
    @GetMapping
    public ResponseEntity<Page<Materiale>> getMateriale(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "12") int size) {
        return ResponseEntity.ok().body(materialeService.getAllMateriale(page, size));
    }

    @GetMapping("/no-pagination")
    public ResponseEntity<List<Materiale>> getMaterialeNoPagination() {
        return ResponseEntity.ok().body(materialeService.getAllMaterialeNoPagination());
    }

    /**
     * Gets a material by its unique identifier.
     *
     * @param id the unique identifier of the material.
     * @return the ResponseEntity with status 200 (OK) and the found material in body.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Materiale> getMaterialeById(@PathVariable String id) {
        return ResponseEntity.ok().body(materialeService.getMaterialeById(id));
    }

    /**
     * Uploads a photo for a material.
     *
     * @param id the unique identifier of the material.
     * @param file the photo to upload.
     * @return the ResponseEntity with status 200 (OK) and with body the material.
     */
    @PostMapping("/photo")
    public ResponseEntity<String> uploadPhoto(@RequestParam(value = "id") String id,
                                              @RequestParam(value = "file") MultipartFile file) {
        return ResponseEntity.ok().body(materialeService.uploadPhoto(id, file));
    }

    /**
     * Deletes a material by its unique identifier.
     *
     * @param id the unique identifier of the material.
     * @return the ResponseEntity with status 200 (OK) and with body a message indicating the material was deleted.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMateriale(@PathVariable String id) {
        materialeService.deleteMateriale(id);
        return ResponseEntity.ok().body("Materiale deleted");
    }

    /**
     * Gets a photo by its file name.
     *
     * @param filename the name of the file.
     * @return the byte array of the photo.
     * @trhows Exception if the file is not found or cannot be read.
     */
    @GetMapping(path = "/image/{fileName}", produces = {IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE})
    public byte[] getPhoto(@PathVariable("fileName") String filename) throws Exception {
        Path filePath = Paths.get(PHOTO_DIR + filename);
        if(Files.exists(filePath)) {
            return Files.readAllBytes(filePath);
        } else {
            log.error("File not found: {}", filename);
            throw new RuntimeException("File not found");
        }
    }
}
