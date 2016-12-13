package pl.dmcs.mcypel.bachelors_degree.application.model.load.manager;

import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 08.12.2016.
 */
public interface SignalLoadManager {

    ECGSignal loadSignal(FolderChooseManager folderChooseManager);

    PatientPersonalData loadPatientData(FolderChooseManager folderChooseManager);

}
