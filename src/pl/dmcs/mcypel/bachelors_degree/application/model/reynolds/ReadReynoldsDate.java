package pl.dmcs.mcypel.bachelors_degree.application.model.reynolds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.Duration;

//import pl.dmcs.med38.impl.signals.duration.Duration;
//import pl.dmcs.med38.utils.constants.KardioConstants;

public class ReadReynoldsDate {

	public static Duration load(String path) {
		Duration result;
		File directoryInfo = new File(path + File.separator + "patient.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(directoryInfo));
			try {
				String s;
				int counter = 0;
				DateTime time = null;
				int year = 0;
				int month = 0;
				int day = 0;
				int hour = 0;
				int minute = 0;
				int second = 0;
				while ((s = in.readLine()) != null) {
					counter++;
					if (counter == 2) {
						day = Integer.parseInt(s.substring(0, 2));
						month = Integer.parseInt(s.substring(3, 5));
						year = Integer.parseInt(s.substring(6, 10));
						hour = Integer.parseInt(s.substring(14, 16));
						minute = Integer.parseInt(s.substring(17, 19));
						second = Integer.parseInt(s.substring(20, 22));
					}
				}
				FileInputStream directoryCrecg = new FileInputStream(path + File.separator + "rawecg1.dat");
				int size = directoryCrecg.available() / 2;
				time = new DateTime(year, month, day, hour, minute, second);
				result = new Duration(time.minus(size / 128), time);
//				result.setEndTime(time);
//				result.setBeginTime(time.minusSeconds(size/KardioConstants.samplingFrequencyReynolds));
				directoryCrecg.close();
			}
			finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
