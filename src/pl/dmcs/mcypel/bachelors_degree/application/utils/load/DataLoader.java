package pl.dmcs.mcypel.bachelors_degree.application.utils.load;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.dmcs.mcypel.bachelors_degree.application.model.examination.ExaminationData;
import pl.dmcs.mcypel.bachelors_degree.application.utils.folder.manager.FolderChooseManager;
import pl.dmcs.mcypel.bachelors_degree.application.utils.load.manager.ElectrocardiographLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.utils.load.manager.DataLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.io.IOException;

/**
 * Created by Matson on 08.12.2016.
 */
public class DataLoader implements DataLoadManager {

    private FolderChooseManager folderChooseManager;
    private ElectrocardiographLoadManager electrocardiographLoader;

    public DataLoader(FolderChooseManager folderChooseManager){
        this.folderChooseManager = folderChooseManager;
        electrocardiographLoader = getElectrocartiographLoader();

    }
    // TODO: 24.11.2016 wczytywanie danych w nowym watku -- tu tez?

    @Override
    public ECGSignal loadSignal() throws IOException {
        String path = folderChooseManager.getFolderPath();
        int channels = electrocardiographLoader.loadNumberOfChannels(path);
        ECGSignal ecgSignal = electrocardiographLoader.loadECGSignal(path, channels);
        if (ecgSignal != null)
            return ecgSignal;
        else
            throw new IOException("ecgSignal is null");
    }

    @Override
    public ExaminationData loadExaminationData() throws IOException {
        String path = folderChooseManager.getFolderPath();
        int channels = electrocardiographLoader.loadNumberOfChannels(path);

        PatientPersonalData patientData = electrocardiographLoader.loadPatientData(path);
        DateTime examinationDate = electrocardiographLoader.loadExaminationDate(path);
        Duration examinationDuration = electrocardiographLoader.loadExaminationDuration(path, examinationDate,channels);
        return new ExaminationData(patientData, examinationDate, examinationDuration);
        // TODO: 20.12.2016 jakies zabezpieczenia tak jak w load signal??
    }

    private ElectrocardiographLoadManager getElectrocartiographLoader() {
        String folderName = folderChooseManager.getFolderName();
        if (isCardioScan(folderName))
            return new CardioscanLoader();
        if (isReynolds(folderName))
            return new ReynoldsLoader();

        return null;
    }

    private boolean isCardioScan(String folderName){
        return folderName.contains("Save");
    }

    private boolean isReynolds(String folderName){
        return folderName.contains(".FUL");
    }

}
