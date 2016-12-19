package pl.dmcs.mcypel.bachelors_degree.application.model.save;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import pl.dmcs.mcypel.bachelors_degree.application.model.save.manager.ImageSaveManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matson on 12.12.2016.
 */
public class ImageRecorder implements ImageSaveManager
{
    private final static String SAVE_CHART_DIALOG_NAME = "Save graph";
    private final static String PNG_DESCRIPTION = "Portable Network Graphics";
    private final static String JPG_DESCRIPTION = "Joint Photographic Experts Group";
    private final static String BMP_DESCRIPTION = "Windows Bitmap";
    private final static String PNG_EXTENSION = "*.png";
    private final static String JPG_EXTENSION = "*.jpg";
    private final static String BMP_EXTENSION = "*.bmp";

    private FileChooser fileChooser;
    private File file;
    private WritableImage writableImage;

    public ImageRecorder() {
        fileChooser = new FileChooser();
        prepareSaveDialogProperties();
        prepareExtensionFilters();
    }

    private void prepareSaveDialogProperties() {
        fileChooser.setTitle(SAVE_CHART_DIALOG_NAME); //chyba ze bedzie tez cos innego zapisywane niz chart
    }
    private void prepareExtensionFilters() {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(PNG_DESCRIPTION, PNG_EXTENSION),
                new FileChooser.ExtensionFilter(JPG_DESCRIPTION, JPG_EXTENSION),
                new FileChooser.ExtensionFilter(BMP_DESCRIPTION, BMP_EXTENSION)
        );
    }

    @Override
    public void save(Window window, Node node) {
        prepareSaveFile(window);
        takeSnapshot(node);
        imageWrite();
    }

    private void prepareSaveFile(Window window){
        file = fileChooser.showSaveDialog(window);
        // TODO: 26.11.2016 dodać zabezpieczenia jakies null, jak cancel poelci itp
    }

    private void takeSnapshot(Node node){
        writableImage = node.snapshot(new SnapshotParameters(), null);
    }

    private void imageWrite() {
        try{
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
        }catch (IOException e){
            // TODO: 20.11.2016 handle exception
        }
    }
}
