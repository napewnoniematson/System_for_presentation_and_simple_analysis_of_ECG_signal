package pl.dmcs.mcypel.bachelors_degree.application.model.folder.manager;

import javafx.stage.Window;

import java.io.IOException;

/**
 * Created by Matson on 08.12.2016.
 */
public interface FolderChooseManager {

    void chooseOpenFolder(Window window) throws IOException;

    String getFolderName();

    String getFolderPath();



}
