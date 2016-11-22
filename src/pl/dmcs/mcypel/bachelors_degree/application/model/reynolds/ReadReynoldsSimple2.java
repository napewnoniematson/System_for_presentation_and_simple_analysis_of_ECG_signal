package pl.dmcs.mcypel.bachelors_degree.application.model.reynolds;

import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/*import pl.dmcs.med38.impl.signals.general.ECGSignal;
import pl.dmcs.med38.utils.constants.KardioConstants;*/

public class ReadReynoldsSimple2 {

	public static ECGSignal load(String path, int channels)
	{
		try {
			
			int size = (new FileInputStream(path + "//rawecg1.dat")).available();
			ECGSignal signal = new ECGSignal(channels, size / 2,128);
			
			for(int i = 0; i<channels; ++i) 
			{
				FileInputStream readSource = new FileInputStream(path + "//rawecg" + (i+1) + ".dat");
				
				BufferedInputStream readBuffer =new BufferedInputStream(readSource);
				
				for (int j = 0 ; j < size/2; ++j)
				{	
					//if ((j % (size/200)) == 0 ) System.out.println(j*200/size);
					
					int bajt1 = readBuffer.read();
					int bajt2 = readBuffer.read();
										
					signal.setSample(i,j ,(float)(bajt2 * 16  + bajt1/16));
				}
				
			}
			
//			signal.setDuration(ReadReynoldsDate.load(path));
			
		return signal;

		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
}
