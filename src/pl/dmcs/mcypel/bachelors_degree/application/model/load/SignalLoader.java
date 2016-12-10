package pl.dmcs.mcypel.bachelors_degree.application.model.load;

import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.ReadCardioPathNumberOfChannels;
import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.ReadCardioPathSimple2;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.FolderChooseManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.SignalLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.reynolds.ReadReynoldsNumberOfChannels;
import pl.dmcs.mcypel.bachelors_degree.application.model.reynolds.ReadReynoldsSimple2;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 08.12.2016.
 */
public class SignalLoader implements SignalLoadManager {

    private ECGSignal ecgSignal;
    private FolderChooseManager folderChooseManager;

    public SignalLoader(){
        folderChooseManager = new FolderChooser();
    }
    // TODO: 24.11.2016 wczytywanie danych w nowym watku -- tu tez?

    @Override
    public ECGSignal loadSignal() {
        folderChooseManager.chooseFolder();
        if (isCardioScan(folderChooseManager.getFolderName()))
            ecgSignal = loadCardioScan();
        if(isReynolds(folderChooseManager.getFolderName()))
            ecgSignal = loadReynolds();
        // TODO: 20.11.2016 ogarnac co zrobic gdy sie nie powiedzie wczytanie i mialoby zwrocic nulla
        return ecgSignal;
    }

    private boolean isCardioScan(String folderName){
        return folderName.contains("Save");
    }

    private ECGSignal loadCardioScan(){
        return ReadCardioPathSimple2.load(folderChooseManager.getFolderPath(),
                ReadCardioPathNumberOfChannels.load(folderChooseManager.getFolderPath()));
    }

    private boolean isReynolds(String folderName){
        return folderName.contains(".FUL");
    }

    private ECGSignal loadReynolds(){
        return ReadReynoldsSimple2.load(folderChooseManager.getFolderPath(),
                ReadReynoldsNumberOfChannels.load(folderChooseManager.getFolderPath()));
    }
}
