package pl.dmcs.mcypel.bachelors_degree.application.model.load;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan.*;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.ElectrocardiographLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 20.12.2016.
 */
public class CardioscanLoader implements ElectrocardiographLoadManager {

    @Override
    public ECGSignal loadECGSignal(String path, int channels) {
        return ReadCardioPathSimple2.load(path, channels);
    }

    @Override
    public PatientPersonalData loadPatientData(String path) {
        return ReadCardioPathPatientPersonalData.load(path);
    }

    @Override
    public DateTime loadExaminationDate(String path) {
        return ReadCardioPathDate.load(path);
    }

    @Override
    public Duration loadExaminationDuration(String path, DateTime examinationDate, int channels) {
        return ReadCardioPathDuration.load(path, examinationDate, channels);
    }

    @Override
    public int loadNumberOfChannels(String path) {
        return ReadCardioPathNumberOfChannels.load(path);
    }
}
