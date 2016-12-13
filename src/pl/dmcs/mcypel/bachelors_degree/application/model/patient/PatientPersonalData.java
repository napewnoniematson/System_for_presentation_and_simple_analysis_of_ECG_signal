package pl.dmcs.mcypel.bachelors_degree.application.model.patient;

/**
 * Created by Matson on 13.12.2016.
 */
public class PatientPersonalData {

    private String name;
    private String surname;


    public PatientPersonalData(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
