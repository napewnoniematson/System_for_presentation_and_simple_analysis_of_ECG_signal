package pl.dmcs.mcypel.bachelors_degree.application.utils.filter;

/**
 * Created by Matson on 06.01.2017.
 */
public class LowPassFilter {

    public static float[] filter(float[] inputSignal, float samplingFrequency, float cutoffFrequency) {

        float alpha = alpha(samplingFrequency, cutoffFrequency);
        float value = inputSignal[0];

        for (int i = 1; i < inputSignal.length; ++i) {
            float currentValue = inputSignal[i];
            value += (currentValue - value) * alpha;
            inputSignal[i] = value;
        }
        return inputSignal;
    }

    private static float alpha(float samplingFrequency, float cutoffFrequency) {
        float RC = (float) (1/(2* Math.PI * cutoffFrequency));
        float dt = 1/samplingFrequency;
        return dt/(dt + RC);
    }
}
