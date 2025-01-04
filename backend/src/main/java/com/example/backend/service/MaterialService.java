package com.example.backend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.backend.domain.Material;
import com.example.backend.repo.MaterialRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import static com.example.backend.constant.Constant.PHOTO_DIR;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


import java.util.List;


@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor

public class MaterialService {
    private final MaterialRepo materialRepo;

    /**
     * Gets all materials with pagination and sorting by title.
     *
     * @param page the page number to retrieve.
     * @param size the number of materials per page.
     * @return the list of all materials.
     */
    public Page<Material> getAllMaterials(int page, int size) {
        return materialRepo.findAll(PageRequest.of(page, size, Sort.by("title")));
    }

    public List<Material> getAllMaterialsNoPagination() {
        return materialRepo.findAll();
    }

    /**
     * Gets a material by its unique identifier.
     *
     * @param id the unique identifier of the material.
     * @return the found material.
     * @throws RuntimeException if the material is not found.
     */
    public Material getMaterialById(String id) {
        return materialRepo.findMaterialById(id).orElseThrow(() -> new RuntimeException("Material not found"));
    }

    /**
     * Creates a new material.
     *
     * @param material the material to create.
     * @return the created material.
     */
    public Material createMaterial(Material material) {
        return materialRepo.save(material);
    }

    /**
     * Deletes a material by its unique identifier.
     *
     * @param id the unique identifier of the material.
     */
    public void deleteMaterial(String id) {
        materialRepo.deleteById(Long.valueOf(id));
    }

    /**
     * Uploads a photo for a material.
     *
     * @param id   the unique identifier of the material.
     * @param file the photo to upload.
     * @return the URL of the uploaded photo.
     */
    public String uploadPhoto(String id, MultipartFile file) {
        log.info("Uploading photo for material with id: {}", id);
        Material material = getMaterialById(id);
        String photoURL = photoFunction.apply(id, file);
        material.setPhotoURL(photoURL);
        materialRepo.save(material);
        return photoURL;
    }

    /**
     * Function to get the file extension from the file name.
     */
    private final Function<String, String> fileExtension = fileName -> Optional.of(fileName)
            .filter(name -> name.contains("."))
            .map(name -> name.substring(name.lastIndexOf(".") + 1))
            .orElse(".png");

    /**
     * BiFunction to handle the photo upload process.
     */
    private final BiFunction<String, MultipartFile, String> photoFunction = (id, image) ->
    {
        String filename = id + fileExtension.apply(image.getOriginalFilename());
        try {
            Path fileStorageLocation = Paths.get(PHOTO_DIR).toAbsolutePath().normalize();
            if (!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING);
            return ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/books/image/" + filename).toUriString();
        }
        catch (Exception e){
            log.error("Error uploading photo", e);
            throw new RuntimeException("Error uploading photo", e);
        }
    };
}
