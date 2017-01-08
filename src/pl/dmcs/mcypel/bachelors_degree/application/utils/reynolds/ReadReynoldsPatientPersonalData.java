package pl.dmcs.mcypel.bachelors_degree.application.utils.reynolds;

import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;
import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Matson on 13.12.2016.
 */
public class ReadReynoldsPatientPersonalData {

    public static PatientPersonalData load(String path) {

        PatientPersonalData patientData;
        String readedLine;
        String name = "";
        String surname = "";
        int counter = 0;

        File directoryInfo = new File(path + File.separator + "patient.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(directoryInfo));
            try {
                while ((readedLine = in.readLine()) != null) {
                    counter++;
                    if(counter == 3) {
                        String[] data = readedLine.split("\\s+");
                        surname = data[0];
                        name = data[1];
                    }
                }
                patientData = new PatientPersonalData(name, surname);
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.log(ReadReynoldsPatientPersonalData.class, "return PatientData, name: "
                + patientData.getName()
                + " surname: " + patientData.getSurname());
        return patientData;

    }

}
