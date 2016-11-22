package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matson on 20.11.2016.
 */
public class SaveManager {

    public SaveManager(){

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
