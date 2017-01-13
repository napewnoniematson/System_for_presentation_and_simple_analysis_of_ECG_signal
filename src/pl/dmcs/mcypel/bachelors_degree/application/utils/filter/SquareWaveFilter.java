package pl.dmcs.mcypel.bachelors_degree.application.utils.filter;

import pl.dmcs.mcypel.bachelors_degree.application.utils.Math;

/**
 * Created by Matson on 12.01.2017.
 */
public final class SquareWaveFilter {

    public static float[] filter(float[] inputSignal, float samplingFrequency, float low, float high) {

        int counter = 0;
        int cutoff = 0;

        while (counter < 20000) {
            if (areSame(inputSignal, counter) &&
                    areSame(inputSignal, (counter + (int)samplingFrequency)) &&
                    inputSignal[counter] == inputSignal[counter + (int)samplingFrequency] &&
                    (inputSignal[counter] == low || inputSignal[counter] == high)) {
                counter += samplingFrequency;
                cutoff = counter;
            } else
                counter++;
        }

        float[] output = new float[inputSignal.length - cutoff];
        for (int i = cutoff; i < inputSignal.length; ++i) {
            output[i - cutoff] = inputSignal[i];
        }
        return output;
    }

    private static boolean areSame (float[] input, int counter) {
        return input[counter] == input[counter + 1] &&
                input[counter + 1] == input[counter + 2] &&
                input[counter + 2] == input[counter + 3] &&
                input[counter + 3] == input[counter + 4];
    }

}