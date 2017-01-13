package pl.dmcs.mcypel.bachelors_degree.application.utils;

/**
 * Created by Matson on 12.01.2017.
 */
public final class Math {

    public static float min(float[] inputSignal, int start, int stop) {

        float current, min;
        min = inputSignal[start] ;

        for (int i = start + 1; i < stop; ++i) {
            current = inputSignal[i];
                if (min > current)
                    min = current;
        }
        return min;
    }

    public static float max(float[] inputSignal, int start, int stop) {
        float current, max;
        max = inputSignal[start] ;

        for (int i = start + 1; i < stop; ++i) {
            current = inputSignal[i];
            if (max < current)
                max = current;
        }
        return max;
    }


}