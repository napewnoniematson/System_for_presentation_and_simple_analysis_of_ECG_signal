package pl.dmcs.mcypel.bachelors_degree.application.model.folder;

import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import pl.dmcs.mcypel.bachelors_degree.application.model.folder.manager.FolderChooseManager;

import java.io.File;
import java.io.IOException;

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
    public void chooseOpenFolder(Window window) throws IOException {
        file = directoryChooser.showDialog(window);
        if (file == null)
            throw new IOException("File is null");
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
