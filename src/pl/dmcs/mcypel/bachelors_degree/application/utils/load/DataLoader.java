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

    public DataLoader(FolderChooseManager folderChooseManager) throws IOException {
        this.folderChooseManager = folderChooseManager;
        electrocardiographLoader = getElectrocartiographLoader();

    }

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
    }

    private ElectrocardiographLoadManager getElectrocartiographLoader() throws IOException{
        String folderName = folderChooseManager.getFolderName();
        if (isCardioScan(folderName))
            return new CardioscanLoader();
        if (isReynolds(folderName))
            return new ReynoldsLoader();
        throw new IOException("Wrong folder choosen");
    }

    private boolean isCardioScan(String folderName){
        return folderName.contains("Save");
    }

    private boolean isReynolds(String folderName){
        return folderName.contains(".FUL");
    }

}
