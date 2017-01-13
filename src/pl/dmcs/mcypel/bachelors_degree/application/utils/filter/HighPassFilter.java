package pl.dmcs.mcypel.bachelors_degree.application.utils.filter;

/**
 * Created by Matson on 12.01.2017.
 */
public final class HighPassFilter {

    public static float[] filter(float[] inputSignal, float samplingFrequency, float cutoffFrequency) {

        float alpha = alpha(samplingFrequency, cutoffFrequency);
        float value = inputSignal[0];
        float[] output = new float[inputSignal.length];

        output[0] = value;
        for (int i = 1; i < inputSignal.length; ++i) {
            float currentValue = inputSignal[i];
            float previousValue = inputSignal[i-1];
            value = (value + currentValue - previousValue) * alpha;
            output[i] = value;
        }
        return output;
    }

    private static float alpha(float samplingFrequency, float cutoffFrequency) {
        float RC = (float) (1/(2* Math.PI * cutoffFrequency));
        float dt = 1/samplingFrequency;
        return RC/(RC + dt);
    }


}
