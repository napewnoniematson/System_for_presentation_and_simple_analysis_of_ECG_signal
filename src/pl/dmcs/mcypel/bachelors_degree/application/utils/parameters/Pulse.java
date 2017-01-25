package pl.dmcs.mcypel.bachelors_degree.application.utils.parameters;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Matson on 25.01.2017.
 */
public final class Pulse {

    public static int calculate(float[] peaksSignal, IntegerProperty lowerBound,
                                            IntegerProperty upperBound, float samplingFrequency) {
        int middle = (lowerBound.get() + upperBound.get()) / 2;
        int samplesPerMinute = (int)(samplingFrequency * 60);
        int start = middle - samplesPerMinute/2;
        int stop = middle + samplesPerMinute/2;
        int counter = 0;
        if (!(start < 0 || stop > peaksSignal.length)) {
            for (int i = start; i < stop; ++i) {
                if(peaksSignal[i] == 1)
                    counter++;
            }
            return counter;
        }
        return 0;
    }
}
