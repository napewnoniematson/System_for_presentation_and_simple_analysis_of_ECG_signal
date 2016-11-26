package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matson on 20.11.2016.
 */
public class SaveManager {
    // TODO: 24.11.2016 zapis w nowym watku -- ????
    public SaveManager(){}

    private WritableImage getSnapshot(Node node){
        return node.snapshot(new SnapshotParameters(), null);
    }

    private File prepareSaveFile(Window window){
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(window);
        // TODO: 26.11.2016 dodać zabezpieczenia jakies null, jak cancel poelci itp
    }

    public void saveImage(WritableImage writableImage){
        File file = prepareSaveFile(null);
        try{
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);

        }catch (IOException e){
            // TODO: 20.11.2016 handle exception
        }
    }
}
