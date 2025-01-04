package com.example.backend.resource;

import com.example.backend.domain.Material;
import com.example.backend.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Path;
import java.nio.file.Paths;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;
import static com.example.backend.constant.Constant.PHOTO_DIR;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/materiale")
@RequiredArgsConstructor

public class MaterialResource {
    private final MaterialService materialService;

    /**
     * Creates a new material.
     * @param material the material to create.
     * @return the ResponseEntity with status 201 (Created) and with body the new material.
     */
    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        return ResponseEntity.created(URI.create("/materiale/materialID")).body(materialService.createMaterial(material));
    }

    /**
     * Gets all materials with pagination.
     *
     * @param page the page number to retrieve.
     * @param size the size of the material per page.
     * @return the ResponseEntity with status 200 (OK) and the list of materials in body.
     */
    @GetMapping
    public ResponseEntity<Page<Material>> getMaterials(@RequestParam(value = "page", defaultValue = "0") int page,
                                                       @RequestParam(value = "size", defaultValue = "12") int size) {
        return ResponseEntity.ok().body(materialService.getAllMaterials(page, size));
    }

    @GetMapping("/no-pagination")
    public ResponseEntity<List<Material>> getMaterialsNoPagination() {
        return ResponseEntity.ok().body(materialService.getAllMaterialsNoPagination());
    }

    /**
     * Gets a material by its unique identifier.
     *
     * @param id the unique identifier of the material.
     * @return the ResponseEntity with status 200 (OK) and with body the material.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok().body(materialService.getMaterialById(id));
    }

    /**
     * Uplaods a photo for a material.
     *
     * @param id the unique identifier of the material.
     * @param file the photo to upload.
     * @return the ResponseEntity with status 200 (OK) and with body the material.
     */
    @PostMapping("/photo")
    public ResponseEntity<String> uploadPhoto(@RequestParam(value = "id") String id,
                                                @RequestParam(value = "file") MultipartFile file) {
        return ResponseEntity.ok().body(materialService.uploadPhoto(id, file));
    }

    /**
     * Deletes a material by its unique identifier.
     *
     * @param id the unique identifier of the material.
     * @return the ResponseEntity with status 204 (NO_CONTENT).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaterial(@PathVariable(value = "id") String id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.ok().body("Material was deleted.");
    }

    /**
     * Gets a photo by its file name.
     *
     * @param fileName the name of the file.
     * @return the byre of the photo.
     * @throws IOException if the photo cannot be read.
     */
    @GetMapping(path = "/image/{fileName}", produces = {IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE})
    public byte[] getPhoto(@PathVariable("fileName") String fileName) throws Exception {
        Path filePath = Paths.get(PHOTO_DIR + fileName);
        if (Files.exists(filePath)) {
            return Files.readAllBytes(filePath);
        } else {
            log.error("File not found: {}", fileName);
            throw new RuntimeException("File not found");
        }
    }
}
