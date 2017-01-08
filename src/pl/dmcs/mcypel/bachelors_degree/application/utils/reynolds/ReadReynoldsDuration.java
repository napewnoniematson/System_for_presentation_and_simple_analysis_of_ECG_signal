package pl.dmcs.mcypel.bachelors_degree.application.utils.reynolds;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Matson on 13.12.2016.
 */
public class ReadReynoldsDuration {

    public static Duration load(String path, DateTime dateTime) {

        FileInputStream directoryCrecg;
        Duration duration;

        try {
            directoryCrecg = new FileInputStream(path + File.separator + "rawecg1.dat");
            int size = directoryCrecg.available() / 2;
            directoryCrecg.close();
            duration = new Duration(dateTime.minus(size / 128), dateTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.log(ReadReynoldsDuration.class, "return duration: " + duration);
        return duration;
    }
}
