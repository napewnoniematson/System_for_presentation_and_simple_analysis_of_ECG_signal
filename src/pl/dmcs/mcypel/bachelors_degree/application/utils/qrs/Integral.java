package pl.dmcs.mcypel.bachelors_degree.application.utils.qrs;

/**
 * Created by Matson on 16.01.2017.
 */
public class Integral {

    public static float[] integration(float[] inputSignal) {
        float[] output = new float[inputSignal.length - 24];
        for (int i = 24; i < inputSignal.length; ++i) {
            float value = 0;
            for (int j = 0; j < 25; ++j) {
                value += inputSignal[i - j];
            }
            output[i - 24] = value/25;
        }
        return output;
    }
}
