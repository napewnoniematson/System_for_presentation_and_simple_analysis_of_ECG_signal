package pl.dmcs.mcypel.bachelors_degree.application.utils.file.manager;

import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

/**
 * Created by Matson on 19.12.2016.
 */
public interface ImageFileChooseManager {

    File chooseSaveFile(Window window) throws IOException;
}
