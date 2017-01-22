package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import pl.dmcs.mcypel.bachelors_degree.application.model.examination.ExaminationData;

/**
 * Created by Matson on 08.01.2017.
 */
public class ExaminationDataController {

    @FXML
    private BorderPane examinationPane;

    @FXML
    private Label namePatientLbl,surnamePatientLbl, examinationDateLbl, examinationTimeLbl,
            folderNameLbl, frequencyLbl;

    public void showDataOnView(String folderName, int frequency, ExaminationData examinationData) {
        folderNameLbl.setText(folderName);
        frequencyLbl.setText(frequency + " Hz");
        namePatientLbl.setText(getPatientName(examinationData));
        surnamePatientLbl.setText(getPatiendSurname(examinationData));
        examinationDateLbl.setText(getExaminationDate(examinationData));
        examinationTimeLbl.setText(getExaminationTime(examinationData));
    }

    public BorderPane getExaminationPane() {
        return examinationPane;
    }

    private String getPatientName(ExaminationData examinationData) {
        return examinationData.getPatientPersonalData().getName();
    }

    private String getPatiendSurname(ExaminationData examinationData) {
        return examinationData.getPatientPersonalData().getSurname();
    }

    private String getExaminationDate(ExaminationData examinationData) {
        int month = examinationData.getExaminationDate().getMonthOfYear();
        int day = examinationData.getExaminationDate().getDayOfMonth();
        int year = examinationData.getExaminationDate().getYear();

        return stringFromDateInt(month)
                + "-"
                + stringFromDateInt(day)
                + "-"
                + stringFromDateInt(year);
    }

    private String getExaminationTime(ExaminationData examinationData) {
        int hour = examinationData.getExaminationDate().getHourOfDay();
        int minute = examinationData.getExaminationDate().getMinuteOfHour();
        int second = examinationData.getExaminationDate().getSecondOfMinute();

        return stringFromDateInt(hour)
                + ":"
                + stringFromDateInt(minute)
                + ":"
                + stringFromDateInt(second);
    }

    private String getDuration(ExaminationData examinationData) {
        return null;
    }

    private String stringFromDateInt (int date) {
        if (date <10)
            return "0" + date;
        else
            return String.valueOf(date);
    }
}
