package pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan;

import pl.dmcs.mcypel.bachelors_degree.application.model.patient.PatientPersonalData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Matson on 13.12.2016.
 */
public class ReadCardioPathPatientPersonalData {

    public static PatientPersonalData load(String path) {

        PatientPersonalData patientData;
        String readedLine;
        String name = "";
        String surname = "";
        int counter = 0;

        File directoryInfo = new File(path + File.separator + "info.pat");
        try{
            BufferedReader in = new BufferedReader(new FileReader(directoryInfo));
            try {
                while((readedLine = in.readLine()) != null) {
                    counter++;
                    if(counter == 9)
                        name = readedLine;
                    if(counter == 10)
                        surname = readedLine;
                }
                patientData = new PatientPersonalData(name, surname);
            }finally {
                in.close();
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        return patientData;
    }
}
