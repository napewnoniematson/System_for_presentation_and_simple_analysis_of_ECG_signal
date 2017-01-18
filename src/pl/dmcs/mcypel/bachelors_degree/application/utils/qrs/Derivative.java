package pl.dmcs.mcypel.bachelors_degree.application.utils.qrs;

/**
 * Created by Matson on 16.01.2017.
 */
public final class Derivative {

    public static float[] differentation(float[] inputSignal) {
        float[] output = new float[inputSignal.length - 1];
        for (int i = 0; i < inputSignal.length - 1; ++i) {
            output[i] = 128 * (inputSignal[i + 1] - inputSignal[i]);
        }
        return output;
    }
}
