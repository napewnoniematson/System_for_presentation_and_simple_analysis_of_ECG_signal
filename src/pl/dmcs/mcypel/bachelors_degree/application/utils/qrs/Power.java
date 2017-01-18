package pl.dmcs.mcypel.bachelors_degree.application.utils.qrs;

/**
 * Created by Matson on 16.01.2017.
 */
public class Power {
    public static float[] power(float[] inputSignal) {
        float[] output = new float[inputSignal.length];
        for (int i = 0; i < inputSignal.length; ++i) {
            output[i] = inputSignal[i] * inputSignal[i];
        }
        return output;
    }
}
