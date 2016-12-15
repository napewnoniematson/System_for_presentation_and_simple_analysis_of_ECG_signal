package pl.dmcs.mcypel.bachelors_degree.application.model.load.manager;

import java.io.IOException;

/**
 * Created by Matson on 08.12.2016.
 */
public interface FolderChooseManager {

    void chooseFolder() throws IOException;

    String getFolderName();

    String getFolderPath();



}
