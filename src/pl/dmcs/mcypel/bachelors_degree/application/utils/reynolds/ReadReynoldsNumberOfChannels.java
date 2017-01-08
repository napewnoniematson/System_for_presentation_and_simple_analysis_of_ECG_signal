package pl.dmcs.mcypel.bachelors_degree.application.utils.reynolds;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;

public class ReadReynoldsNumberOfChannels {

	public static int load(String path){

		File directoryCrecg = new File(path);
		Collection<File> fileCrecg = FileUtils.listFiles(
				  directoryCrecg,
				  new RegexFileFilter("rawecg.\\.dat"),
				  TrueFileFilter.INSTANCE
				);
		Logger.log(ReadReynoldsNumberOfChannels.class, "return number of channels: " + fileCrecg.size());
		return fileCrecg.size();
	}

}
