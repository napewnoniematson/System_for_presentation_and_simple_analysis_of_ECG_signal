package pl.dmcs.mcypel.bachelors_degree.application.model.load;

import javafx.stage.DirectoryChooser;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.FolderChooseManager;

import java.io.File;

/**
 * Created by Matson on 08.12.2016.
 */
public class FolderChooser implements FolderChooseManager {

    private DirectoryChooser directoryChooser;
    private File file;

    public FolderChooser(){
        directoryChooser = new DirectoryChooser();
    }

    @Override
    public void chooseFolder() {
        file = directoryChooser.showDialog(null);
        // TODO: 20.11.2016 zabezpieczenia gdy ktos kliknie cancel bo zwraca nulla i sie pierdoli w getname,getfolderpath
    }

    @Override
    public String getFolderName() {
        return file.getName();
    }

    @Override
    public String getFolderPath() {
        return file.getPath();
    }
}
