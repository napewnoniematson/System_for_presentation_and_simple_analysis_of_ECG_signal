package pl.dmcs.mcypel.bachelors_degree.application.model.load;

import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.ReadCardioPathNumberOfChannels;
import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.ReadCardioPathPatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.ReadCardioPathSimple2;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.FolderChooseManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.SignalLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.reynolds.ReadReynoldsNumberOfChannels;
import pl.dmcs.mcypel.bachelors_degree.application.model.reynolds.ReadReynoldsPatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.reynolds.ReadReynoldsSimple2;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.io.IOException;

/**
 * Created by Matson on 08.12.2016.
 */
public class SignalLoader implements SignalLoadManager {

    private ECGSignal ecgSignal;
    private PatientPersonalData patientData;
    private FolderChooseManager folderChooseManager;

    public SignalLoader(){
    }
    // TODO: 24.11.2016 wczytywanie danych w nowym watku -- tu tez?

    @Override
    public ECGSignal loadSignal(FolderChooseManager folderChooseManager) throws IOException {
        this.folderChooseManager = folderChooseManager;
        if (isCardioScan())
            loadCardioScan();
        if (isReynolds())
            loadReynolds();
        if (ecgSignal != null)
            return ecgSignal;
        else
            throw new IOException("ecgSignal is null");
    }

    @Override
    public PatientPersonalData loadPatientData(FolderChooseManager folderChooseManager) throws IOException {
        this.folderChooseManager = folderChooseManager;
        if (isCardioScan())
            loadCardioPatientData();
        if (isReynolds())
            loadReynoldsPatientData();

        if (patientData != null)
            return patientData;
        else
            throw new IOException("patientData is null");
    }

    private boolean isCardioScan(){
        return folderChooseManager.getFolderName().contains("Save");
    }

    private void loadCardioScan(){
        ecgSignal = ReadCardioPathSimple2.load(folderChooseManager.getFolderPath(),
                ReadCardioPathNumberOfChannels.load(folderChooseManager.getFolderPath()));
    }

    private void loadCardioPatientData() {
        patientData = ReadCardioPathPatientPersonalData.load(folderChooseManager.getFolderPath());
    }

    private boolean isReynolds(){
        return folderChooseManager.getFolderName().contains(".FUL");
    }

    private void loadReynolds(){
        ecgSignal = ReadReynoldsSimple2.load(folderChooseManager.getFolderPath(),
                ReadReynoldsNumberOfChannels.load(folderChooseManager.getFolderPath()));
    }

    private void loadReynoldsPatientData() {
        patientData = ReadReynoldsPatientPersonalData.load(folderChooseManager.getFolderPath());
    }



}
