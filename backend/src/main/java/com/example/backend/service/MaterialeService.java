package com.example.backend.service;

import com.example.backend.domain.Materiale;
import com.example.backend.repo.MaterialeRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.example.backend.constant.Constant.PHOTO_DIR;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class MaterialeService {
    private final MaterialeRepo materialeRepo;

    /**
     * Gets all materiale with pagination and sorting by name.
     *
     * @param page the page number to retrieve.
     * @param size the number of materiale per page.
     * @return the paginated list of materiale.
     */
    public Page<Materiale> getAllMateriale(int page, int size) {
        return materialeRepo.findAll(PageRequest.of(page, size, Sort.by("title")));
    }

    public List<Materiale> getAllMaterialeNoPagination() {
        return materialeRepo.findAll();
    }

    /**
     * Gets a materiale by its unique identifier.
     *
     * @param id the unique identifier of the materiale.
     * @return the found materiale.
     * @throws RuntimeException if the materiale is not found.
     */
    public Materiale getMaterialeById(String id) {
        return materialeRepo.findMaterialeById(id).orElseThrow(() -> new RuntimeException("Materiale nu a fost gasit"));
    }

    /**
     * Creates a new materiale.
     *
     * @param materiale the materiale to create.
     * @return the created materiale.
     */
    public Materiale createMateriale(Materiale materiale) {
        return materialeRepo.save(materiale);
    }

    /**
     * Deletes a materiale by its unique identifier.
     *
     * @param id the unique identifier of the materiale.
     */
    public void deleteMateriale(String id) {
        materialeRepo.deleteById(id);
    }

    /**
     * Uploads a photo for a materiale.
     *
     * @param id the unique identifier of the materiale.
     * @param file the photo to upload.
     * @return the materiale with the uploaded photo.
     */
    public String uploadPhoto(String id, MultipartFile file){
        log.info("Uploading photo for materiale with id: {}", id);
        Materiale materiale = getMaterialeById(id);
        String photoURL = photoFunction.apply(id, file);
        materiale.setPhotoURL(photoURL);
        materialeRepo.save(materiale);
        return photoURL;
    }

    /**
     * Function to upload a photo for a materiale.
     */
    private final Function<String,String> fileExtension = fileName -> Optional.of(fileName)
            .filter(name -> name.contains("."))
            .map(name -> "." + name.substring(fileName.lastIndexOf(".") + 1))
            .orElse(".png");

    /**
     * BiFunction to upload a photo for a materiale.
     */
    private final BiFunction<String, MultipartFile, String> photoFunction = (id, image) ->
    {
        String filename = id + fileExtension.apply(image.getOriginalFilename());
        try
        {
            Path fileStorageLocation = Paths.get(PHOTO_DIR).toAbsolutePath().normalize();
            if (!Files.exists(fileStorageLocation))
            {
                Files.createDirectories(fileStorageLocation);
            }
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING);
            return ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/books/image/" + filename).toUriString();
        }
        catch (Exception e)
        {
            log.error("Error uploading photo", e);
            throw new RuntimeException("Error uploading photo",e);
        }
    };
}