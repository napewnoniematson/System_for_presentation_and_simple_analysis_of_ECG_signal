package pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan;

import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*import pl.dmcs.med38.impl.signals.general.ECGSignal;
import pl.dmcs.med38.utils.constants.KardioConstants;*/

public class ReadCardioPathSimple2 {

	
	public static ECGSignal load(String path, int channels)
	{

		int channel = 0;
		int bajt;
		
		int i = 0; 
		
		try {
							
			FileInputStream readSource = new FileInputStream(path+File.separator+"crecg.dat");
			int size = readSource.available()/channels;
			ECGSignal signal = new ECGSignal(1,size,128);
			
			//System.out.println(size);
			
			BufferedInputStream readBuffer =new BufferedInputStream(readSource);
						
			while((bajt = readBuffer.read()) != -1)
			{
					if (channel == channels)
					{
						++i;
						channel = 0;
						
					}
				
				if (i >= size) break;
				if (channel == 0) signal.setSample(channel, i, (float)bajt);
				//if ((i % (size/100)) == 0 && channel == 0) System.out.println(i*100/size);
				++channel;
			}
			
//		signal.setDuration(ReadCardioPathDate.load(path));
			
		readBuffer.close();
		
		return signal;
		
		} catch (IOException e) {

			System.out.println(e);
			
		}
		
		return null;
	}
	
	
}
