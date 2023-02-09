package com.javarush.khmelov.service;

import com.javarush.khmelov.config.Config;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    public static void main(String[] args) {
        new ImageService();
    }

    public static final String IMAGES_FOLDER = "images";
    public static final String NO_IMAGE_PNG = "no-image.png";
    public static final List<String> EXTENSIONS = List.of(".jpg", ".jpeg", ".png", ".bmp", ".gif", ".webp");

    private final Path imagesFolder = Config.WEB_INF.resolve(IMAGES_FOLDER);

    @SneakyThrows
    public ImageService() {
        Files.createDirectories(imagesFolder);
    }

    @SneakyThrows
    public Optional<Path> getImagePath(String filename) {
        return EXTENSIONS.stream()
                .map(ext -> imagesFolder.resolve(filename + ext))
                .filter(Files::exists)
                .findAny()
                .or(() -> Optional.of(imagesFolder.resolve(NO_IMAGE_PNG)));
    }

    public void uploadImage(InputStream inputStream, String filename, String imageId) throws IOException {
        if (inputStream.available() > 0) {
            String ext = filename.substring(filename.lastIndexOf("."));
            deleteOldFiles(imageId);
            filename = imageId + ext;
            uploadImageInternal(filename, inputStream);
        }
    }

    private void deleteOldFiles(String filename) {
        EXTENSIONS.stream()
                .map(ext -> imagesFolder.resolve(filename + ext))
                .filter(Files::exists)
                .forEach(p -> {
                    try {
                        Files.deleteIfExists(p);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @SneakyThrows
    private void uploadImageInternal(String name, InputStream data) {
        try (data) {
            if (data.available() > 0) {
                Files.copy(data, imagesFolder.resolve(name), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

}
