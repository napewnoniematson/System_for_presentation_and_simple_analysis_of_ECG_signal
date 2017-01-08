package pl.dmcs.mcypel.bachelors_degree.application.utils.save;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.Window;
import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;
import pl.dmcs.mcypel.bachelors_degree.application.utils.file.ImageFileChooser;
import pl.dmcs.mcypel.bachelors_degree.application.utils.file.manager.ImageFileChooseManager;
import pl.dmcs.mcypel.bachelors_degree.application.utils.save.manager.ImageSaveManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matson on 12.12.2016.
 */
public class ImageRecorder implements ImageSaveManager
{
    private ImageFileChooseManager fileChooser;
    private WritableImage writableImage;

    public ImageRecorder() {
        fileChooser = new ImageFileChooser();
    }

    @Override
    public void save(Window window, Node node) throws IOException {
        takeSnapshot(node);
        imageWrite(window);
        Logger.log(ImageRecorder.class, "Saving complete");
    }

    private void takeSnapshot(Node node){
        writableImage = node.snapshot(new SnapshotParameters(), null);
    }

    private void imageWrite(Window window) throws IOException {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", getSaveFile(window));
    }

    private File getSaveFile(Window window) throws IOException {
        return fileChooser.chooseSaveFile(window);
    }
}
