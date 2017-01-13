package pl.dmcs.mcypel.bachelors_degree.application.utils.filter;

/**
 * Created by Matson on 12.01.2017.
 */
public class InputSignalFilter {

    public static float[] filterSignal(float[] signal, float samplingFrequency,
                                 float cutoffFrequencyHP, float cutoffFrequencyLP,
                                       float low, float high) {
        float[] filteredSignal = SquareWaveFilter.filter(signal, samplingFrequency, low, high);
        return BandPassFilter.filter(filteredSignal, samplingFrequency, cutoffFrequencyHP, cutoffFrequencyLP);
    }

    public static float[][] filterSignals(float[][] signals,  float samplingFrequency,
                                    float cutoffFrequencyHP, float cutoffFrequencyLP,
                                          float low, float high){

        float[][] filteredSignals = new float[signals.length][];

        for (int i = 0; i < signals.length; ++i) {
            filteredSignals[i] = filterSignal(signals[i], samplingFrequency, cutoffFrequencyHP, cutoffFrequencyLP, low, high);
        }
        return filteredSignals;
    }


}
