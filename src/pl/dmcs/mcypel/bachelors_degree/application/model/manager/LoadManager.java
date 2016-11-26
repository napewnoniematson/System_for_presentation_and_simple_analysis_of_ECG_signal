package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.stage.DirectoryChooser;
import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.ReadCardioPathNumberOfChannels;
import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.ReadCardioPathSimple2;
import pl.dmcs.mcypel.bachelors_degree.application.model.reynolds.ReadReynoldsNumberOfChannels;
import pl.dmcs.mcypel.bachelors_degree.application.model.reynolds.ReadReynoldsSimple2;

import java.io.File;

/**
 * Created by Matson on 20.11.2016.
 */
public class LoadManager {

    private DirectoryChooser directoryChooser;
    private File file;
    private ECGSignal ecgSignal;


    public LoadManager(){
        directoryChooser = new DirectoryChooser();
    }

    // TODO: 24.11.2016 wczytywanie danych w nowym watku -- tu tez?

    public ECGSignal load(){
        chooseFolder();

        if (isCardioScan(getFolderName()))
            ecgSignal = loadCardioScan();

        if(isReynolds(getFolderName()))
            ecgSignal = loadReynolds();

        // TODO: 20.11.2016 ogarnac co zrobic gdy sie nie powiedzie wczytanie i mialoby zwrocic nulla
        return ecgSignal;

    }

    private boolean isCardioScan(String folderName){
        return folderName.contains("Save");
    }

    private boolean isReynolds(String folderName){
        return folderName.contains(".FUL");
    }


    private void chooseFolder(){
        file = directoryChooser.showDialog(null);
        // TODO: 20.11.2016 zabezpieczenia gdy ktos kliknie cancel bo zwraca nulla i sie pierdoli w getname,getfolderpath
    }

    private String getFolderName(){
        return file.getName();
    }

    private String getFolderPath(){
        return file.getPath();
    }

    private ECGSignal loadCardioScan(){
        return ReadCardioPathSimple2.load(getFolderPath(), ReadCardioPathNumberOfChannels.load(getFolderPath()));
    }

    private ECGSignal loadReynolds(){
        return ReadReynoldsSimple2.load(getFolderPath(), ReadReynoldsNumberOfChannels.load(getFolderPath()));
    }



}
