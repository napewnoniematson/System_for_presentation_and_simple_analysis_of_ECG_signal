package pl.dmcs.mcypel.bachelors_degree.application.model.examination;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;

/**
 * Created by Matson on 20.12.2016.
 */
public class ExaminationData {

    private PatientPersonalData patientPersonalData;
    private DateTime examinationDate;
    private Duration examinationDuration;

    public ExaminationData(PatientPersonalData patientPersonalData,
                           DateTime examinationDate, Duration examinationDuration) {
        this.patientPersonalData = patientPersonalData;
        this.examinationDate = examinationDate;
        this.examinationDuration = examinationDuration;
    }

    public PatientPersonalData getPatientPersonalData() {
        return patientPersonalData;
    }

    public Duration getExaminationDuration() {
        return examinationDuration;
    }

    public DateTime getExaminationDate() {
        return examinationDate;
    }
}
