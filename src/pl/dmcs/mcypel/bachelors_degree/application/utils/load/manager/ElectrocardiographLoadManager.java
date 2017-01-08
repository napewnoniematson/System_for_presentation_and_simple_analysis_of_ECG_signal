package pl.dmcs.mcypel.bachelors_degree.application.utils.load.manager;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 20.12.2016.
 */
public interface ElectrocardiographLoadManager {

    ECGSignal loadECGSignal(String path, int channels);

    PatientPersonalData loadPatientData(String path);

    DateTime loadExaminationDate(String path);

    Duration loadExaminationDuration(String path, DateTime examinationDate, int channels);

    int loadNumberOfChannels(String path);
}
