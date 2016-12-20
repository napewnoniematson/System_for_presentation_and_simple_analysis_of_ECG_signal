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

    public String getPatientName() {
        return patientPersonalData.getName();
    }

    public String getPatiendSurname() {
        return patientPersonalData.getSurname();
    }

    /**
     *
     * @return examination date in format mm-dd-yyyy:
     */
    public String getExaminationDate() {
        return examinationDate.getMonthOfYear()
                + "-"
                + examinationDate.getDayOfMonth()
                + "-"
                + examinationDate.getYear();
    }

    /**
     *
     * @return examination time in format hh:mm:ss
     */
    public String getExaminationTime() {
        return examinationDate.getHourOfDay()
                + ":"
                + examinationDate.getMinuteOfHour()
                + ":"
                + examinationDate.getSecondOfMinute();
    }

    // TODO: 20.12.2016 stegowac getDurationTime
    public String getDuration() {
        return null;
    }





}
