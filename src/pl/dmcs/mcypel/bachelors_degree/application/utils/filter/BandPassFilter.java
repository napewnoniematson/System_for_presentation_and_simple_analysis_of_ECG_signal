package pl.dmcs.mcypel.bachelors_degree.application.utils.filter;

/**
 * Created by Matson on 12.01.2017.
 */
public final class BandPassFilter {

    public static float[] filter(float[] inputSignal, float samplingFrequency,
                                 float cutoffFrequencyHP, float cutoffFrequencyLP) {

        return HighPassFilter.filter(
                LowPassFilter.filter(
                        inputSignal,
                        samplingFrequency,
                        cutoffFrequencyLP),
                samplingFrequency,
                cutoffFrequencyHP);
    }


}
