package ua.com.javarush.quest.gribanov.questdelta.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class ImageService {
    private final String QUEST_IMAGES_FOLDER = "questImages";
    private final String USER_IMAGES_FOLDER = "userImages";
    private static final String NO_IMAGE_PNG = "no-image.png";
    private static final List<String> EXTENSIONS = List.of(".jpg", ".jpeg", ".png", ".bmp", ".gif", ".webp", ".jfif");


    private Path questImages = LoaderService.TEMP_FOLDER_PATH.resolve(QUEST_IMAGES_FOLDER);
    private Path userImages = LoaderService.TEMP_FOLDER_PATH.resolve(USER_IMAGES_FOLDER);

    public Optional<Path> getImagePath(Key key, String filename) {
        fillFoldersIfEmpty();
        Path imagesFolder;
        if (key.equals(Key.QUEST)){
            imagesFolder = questImages;
        } else {
            imagesFolder = userImages;
        }
        return EXTENSIONS.stream()
                .map(ext -> imagesFolder.resolve(filename + ext))
                .filter(Files::exists)
                .findAny()
                .or(() -> Optional.of(imagesFolder.resolve(NO_IMAGE_PNG)));
    }

//    public void uploadImage(HttpServletRequest req) throws IOException, ServletException {
//        Part data = req.getPart("PART_NAME");
//        //todo add a file extension
//        if (data.getInputStream().available() > 0) {
//            String id = req.getParameter("id");
//            String filename = data.getSubmittedFileName();
//            String ext = filename.substring(filename.lastIndexOf("."));
//            deleteOldFiles(FILENAME_PREFIX + id);
//            filename = FILENAME_PREFIX + id + ext;
//            uploadImageInternal(filename, data.getInputStream());
//        }
//    }

    private void fillFoldersIfEmpty() {
        String resourcePathString = FilenameUtils.getPath(ImageService.class.getResource("/").getPath());
        Path resourcesPath = Path.of(resourcePathString.replace("%20", " "));
        Path defaultQuestImages = resourcesPath.resolve(QUEST_IMAGES_FOLDER);
        Path defaultUserImages = resourcesPath.resolve(USER_IMAGES_FOLDER);

        try {
            if (Files.exists(defaultQuestImages)){
                if (!Files.exists(questImages)){
                    Files.createDirectory(questImages);
                }
                if(Files.list(questImages).count() == 0){
                    copyFiles(defaultQuestImages, questImages);
                }
            }
            if (Files.exists(defaultUserImages)){
                if (!Files.exists(userImages)) {
                    Files.createDirectory(userImages);
                }
                if(Files.list(userImages).count() == 0){
                    copyFiles(defaultUserImages, userImages);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void copyFiles(Path source, Path target) {
        try {
            Files.list(source).forEach(f->{
                try {
                    Files.copy(f, target.resolve(f.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public enum Key {
        QUEST,
        USER
    }
}
