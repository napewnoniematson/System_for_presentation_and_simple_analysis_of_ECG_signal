package pl.dmcs.mcypel.bachelors_degree.application.model.cardioscan;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

//import pl.dmcs.med38.impl.signals.general.Beat;
//import pl.dmcs.med38.impl.signals.general.BeatType;
//import pl.dmcs.med38.impl.signals.general.ECGSignal;
//import pl.dmcs.med38.impl.signals.general.FileBeats;

public class ReadCardioPathBeats {

	/*public static FileBeats loadCardioPathBeats(String path)
	{
		//poprawic liczbe kanalow
		ECGSignal signal = ReadCardioPathSimple2.load(path + File.separator + "crecg.dat", ReadCardioPathNumberOfChannels.load(path)); 
		signal.setDuration(ReadCardioPathDate.load(path));

		
		FileBeats beats = new FileBeats(signal, 0);
		int bajt;
		int bajt1=0;
		int bajt2=0;
		int bajt3=0;
		int bajt4=0;
		int beatIndex=0;
		int prevPosition=15360; //128*120
		int flag=0;
		int i = 0; 
		
		try {
					
			FileInputStream readSource = new FileInputStream(path + File.separator + "beats.dbf");
			//int size = readSource.available();
			
			//System.out.println(size);
			
			BufferedInputStream readBuffer =new BufferedInputStream(readSource);
			
			while((bajt = readBuffer.read()) != -1)
			{
				
					i++;
					if (i%16==1) bajt1 = bajt;
					if (i%16==2) bajt2 = bajt;
					if (i%16==3) bajt3 = bajt;
					if (i%16==4) {
						bajt4 = bajt;
						beatIndex  = bajt4*256*256*256+bajt3*256*256+bajt2*256+bajt1;
						//System.out.println("beatIndex " + beatIndex);
					}
					
					//if (i%16==5) System.out.println("hr " + bajt);
					if (i%16==9) {
						flag = bajt;
						//System.out.println("flag " + bajt);
					}
					if (i%16==0) {
						Beat beat = new Beat();
						beat.setTime(prevPosition);
						beat.setLength(beatIndex - prevPosition);
						prevPosition = beatIndex;
						//if (flag!=33 && flag!=6 && flag!=12 && flag!=47 && flag!=34) System.out.println(beats.getData().size() + " ..." + flag);
						
						if (flag == 33) beat.setFlag(BeatType.OK);
						else if (flag == 6) beat.setFlag(BeatType.VENTRICULARTACHYCARDIA);
						else beat.setFlag(BeatType.ARTIFACT);
						
						if (beat.getLength()>0 && beat.getLength()<5000) 
							{
								//System.out.println("naszaDLugosc: " + beat.getLength());
								beats.getData().add(beat);
							}
					}
			}
			
			readBuffer.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return beats;
	}
	*/
}
