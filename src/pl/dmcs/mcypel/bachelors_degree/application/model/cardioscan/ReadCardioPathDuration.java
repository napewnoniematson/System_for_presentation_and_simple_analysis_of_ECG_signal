package pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Matson on 13.12.2016.
 */
public class ReadCardioPathDuration {

    public static Duration load(String path, DateTime dateTime, int channelsNumber) {

        FileInputStream directoryCrecg;
        Duration duration;

        try {
            directoryCrecg = new FileInputStream(path + File.separator + "crecg.dat");
            int size = directoryCrecg.available()/channelsNumber;
            directoryCrecg.close();
            duration = new Duration(dateTime, dateTime.plus(size/128));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.log(ReadCardioPathDate.class, "return duration: " + duration);
        return duration;
    }

}
