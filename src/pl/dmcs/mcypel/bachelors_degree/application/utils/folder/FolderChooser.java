package pl.dmcs.mcypel.bachelors_degree.application.utils.folder;

import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;
import pl.dmcs.mcypel.bachelors_degree.application.utils.folder.manager.FolderChooseManager;

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
        else
            Logger.log(FolderChooser.class, "Creating file from SaveDialog");
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
