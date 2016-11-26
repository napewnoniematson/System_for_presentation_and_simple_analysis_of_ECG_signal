package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;

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

    public void saveChartImage(WritableImage writableImage){
        // TODO: 20.11.2016 prepare method for chooosing file directory - file chooser
        File file = new File("charttestimage.png");
        try{
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);

        }catch (IOException e){
            // TODO: 20.11.2016 handle exception
        }
    }
}
