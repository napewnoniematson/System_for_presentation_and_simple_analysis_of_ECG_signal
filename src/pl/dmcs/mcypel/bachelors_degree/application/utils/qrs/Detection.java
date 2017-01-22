package pl.dmcs.mcypel.bachelors_degree.application.utils.qrs;

import pl.dmcs.mcypel.bachelors_degree.application.utils.Math;

/**
 * Created by Matson on 16.01.2017.
 */
public class Detection {

    private static final float HIGH = 1;
    private static final float LOW = 0;

    public static float normalize (float[] inputSignal, int start) {
        return Math.max(inputSignal, start, start + 500) * 0.2f;
    }

    public static float[] detection (float[] inputSignal) {
        int counter = 500;
        float threshold = 0;
        float[] output = new float[inputSignal.length];
        output[0] = output[1] = output[2] = output[3] = output[4] = LOW;
        for (int i = 5; i < inputSignal.length-500; ++i) {
            output[i] = LOW;
            if (counter == 500){
                threshold = normalize(inputSignal, i);
                counter = 0;
            }
            if (inputSignal[i] > threshold) {
                if (isQRSNoticed(inputSignal, threshold, i))
                    output[i] = HIGH;
            }
            counter++;
        }
        return output;
    }

    private static boolean isQRSNoticed(float[] inputSignal, float threshold, int counter) {
        boolean result = true;
        for (int i = 1; i <= 5; ++i) {
            result = result && (inputSignal[counter - i] > threshold) && (inputSignal[counter + i] > threshold);
        }
        for (int i = 0; i <=10; ++i) {
            result = result && (inputSignal[counter + i ] / inputSignal[counter + i + 1] > 0.95);
        }
        return result;
    }

    public static float[] peaks(float[] inputSignal) {
        float[] output = new float[inputSignal.length];
        for(int i = 0; i < inputSignal.length - 1; ++i) {
            if (inputSignal[i] == HIGH && inputSignal[i + 1] == LOW )
                output[i] = HIGH;
            else
                output[i] = LOW;
        }
        output[inputSignal.length - 1] = 0;
        return output;
    }
}
