package pl.dmcs.mcypel.bachelors_degree.application.model.save.manager;

import javafx.scene.Node;
import javafx.stage.Window;

import java.io.IOException;

/**
 * Created by Matson on 12.12.2016.
 */
public interface ImageSaveManager {

    void save(Window window, Node node) throws IOException;

}
