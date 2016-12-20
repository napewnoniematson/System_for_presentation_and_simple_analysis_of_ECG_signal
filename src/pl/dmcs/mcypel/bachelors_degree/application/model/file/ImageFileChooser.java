package pl.dmcs.mcypel.bachelors_degree.application.model.file;

import javafx.stage.FileChooser;
import javafx.stage.Window;
import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;
import pl.dmcs.mcypel.bachelors_degree.application.model.file.manager.ImageFileChooseManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by Matson on 19.12.2016.
 */
public class ImageFileChooser implements ImageFileChooseManager {


    private FileChooser fileChooser;

    public ImageFileChooser() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Save image to file");
        fileChooser.getExtensionFilters().addAll(
                prepareExtensionFilter(ImageFilters.PNG),
                prepareExtensionFilter(ImageFilters.JPG),
                prepareExtensionFilter(ImageFilters.BMP)
        );
    }

    @Override
    public File chooseSaveFile(Window window) throws IOException {
        File file = fileChooser.showSaveDialog(window);
        if (file != null) {
            Logger.log(ImageFileChooser.class, "Creating file from SaveDialog");
            return file;
        }
        else
            throw new IOException("File is null");
    }

    public FileChooser.ExtensionFilter prepareExtensionFilter(ImageFilters imageFilters) {
        return new FileChooser.ExtensionFilter(imageFilters.description, imageFilters.extension);
    }

    public enum ImageFilters {

        PNG("*.png", "Portable Network Graphics"),
        JPG("*.jpg", "Joint Photographic Experts Group"),
        BMP("*.bmp", "Windows Bitmap");

        private String extension, description;

        ImageFilters(String extension, String description) {
            this.extension = extension;
            this.description = description;
        }
    }
}
