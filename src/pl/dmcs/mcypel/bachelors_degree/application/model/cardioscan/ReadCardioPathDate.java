package pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.Duration;

//import pl.dmcs.med38.impl.signals.duration.Duration;
//import pl.dmcs.med38.utils.constants.KardioConstants;

public class ReadCardioPathDate {

	public static /*Duration */ DateTime load (String path)
	{
//		Duration result;
		File directoryInfo = new File(path + File.separator + "info.pat");
		try {
			BufferedReader in = new BufferedReader(new FileReader(directoryInfo));
			try {
				String s;
				int counter = 0;
				DateTime time = null;
				int channelsNumber = 0;
				int year = 0;
				int month = 0;
				int day = 0;
				int hour = 0;
				int minute = 0;
				int second = 0;
				while ((s = in.readLine()) != null) {
					counter++;
					if (counter == 1)
						channelsNumber = Integer.parseInt(s);
					if (counter == 5) {
						hour = Integer.parseInt(s) / 60;
						minute = Integer.parseInt(s) % 60;
						second = 0;
					}
					if (counter == 6) month = Integer.parseInt(s);
					if (counter == 7) day = Integer.parseInt(s);
					if (counter == 8) year = Integer.parseInt(s);

				}
//				FileInputStream directoryCrecg = new FileInputStream(path + File.separator + "crecg.dat");
//				int size = directoryCrecg.available()/channelsNumber;
//				directoryCrecg.close();
				time = new DateTime(year, month, day, hour, minute, second);
//				result = new Duration(time, time.plus(size/128));

				return time;


//				result.setBeginTime(time);  to nie
//				result.setEndTime(time.plusSeconds(size/KardioConstants.samplingFrequencyCardioPath)); to nie
//				System.out.println("wczytano: " + result.getBeginTime()); to nie
			} finally {
				in.close();
			}
		} catch(IOException e){
			throw new RuntimeException(e);
		}
//		return result;


	}
}
