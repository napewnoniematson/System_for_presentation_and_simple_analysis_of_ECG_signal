package pl.dmcs.mcypel.bachelors_degree.application.utils.cardioscan;

import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadCardioPathNumberOfChannels {

	public static int load(String path){
		int result=0;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(path+ File.separator + "info.pat")));
			String s=in.readLine();
			result=Integer.parseInt(s);
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		Logger.log(ReadCardioPathNumberOfChannels.class, "return result: " + result);
		return result;
	}
	
}
