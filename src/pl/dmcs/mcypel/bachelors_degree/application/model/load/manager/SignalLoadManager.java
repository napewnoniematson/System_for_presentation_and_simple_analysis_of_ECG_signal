package pl.dmcs.mcypel.bachelors_degree.application.model.load.manager;

import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.io.IOException;

/**
 * Created by Matson on 08.12.2016.
 */
public interface SignalLoadManager {

    ECGSignal loadSignal() throws IOException;

    PatientPersonalData loadPatientData() throws IOException;
}
