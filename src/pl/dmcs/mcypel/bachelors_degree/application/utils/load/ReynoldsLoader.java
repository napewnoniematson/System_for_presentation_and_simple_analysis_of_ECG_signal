package pl.dmcs.mcypel.bachelors_degree.application.utils.load;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.dmcs.mcypel.bachelors_degree.application.utils.load.manager.ElectrocardiographLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.utils.reynolds.*;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 20.12.2016.
 */
public class ReynoldsLoader implements ElectrocardiographLoadManager {


    @Override
    public ECGSignal loadECGSignal(String path, int channels) {
        return ReadReynoldsSimple2.load(path, channels);
    }

    @Override
    public PatientPersonalData loadPatientData(String path) {
        return ReadReynoldsPatientPersonalData.load(path);
    }

    @Override
    public DateTime loadExaminationDate(String path) {
        return ReadReynoldsDate.load(path);
    }

    @Override
    public Duration loadExaminationDuration(String path, DateTime examinationDate, int channels) {
        return ReadReynoldsDuration.load(path, examinationDate);
    }

    @Override
    public int loadNumberOfChannels(String path) {
        return ReadReynoldsNumberOfChannels.load(path);
    }
}
