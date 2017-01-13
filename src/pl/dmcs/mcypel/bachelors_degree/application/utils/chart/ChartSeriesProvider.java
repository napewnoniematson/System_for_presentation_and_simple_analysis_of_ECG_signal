package pl.dmcs.mcypel.bachelors_degree.application.utils.chart;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.utils.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.utils.filter.BandPassFilter;
import pl.dmcs.mcypel.bachelors_degree.application.utils.filter.LowPassFilter;

/**
 * Created by Matson on 08.12.2016.
 */
public class ChartSeriesProvider implements ChartSeriesManager {

    private int lowerBound, upperBound, diff;
    private int channels;
    private float[][] filteredSignals;

    public ChartSeriesProvider(float[][] ecgSignals, int channels) {
        this.channels = channels;
        filteredSignals = ecgSignals;
    }

    @Override
    public ObservableList<XYChart.Series> generateSeries(int lowerBound, int upperBound) {
        if (lowerBound < upperBound){
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        } else {
            this.lowerBound = upperBound;
            this.upperBound = lowerBound;
        }
        diff = this.upperBound - this.lowerBound;
        return SeriesGenerator.generate(filteredSignals, this.lowerBound, this.upperBound, channels);
    }

    @Override
    public ObservableList<XYChart.Series> getNextSeries() {
        lowerBound = upperBound;
        upperBound = upperBound + diff;
        return SeriesGenerator.generate(filteredSignals, lowerBound, upperBound, channels);

    }

    @Override
    public ObservableList<XYChart.Series> getPreviousSeries() {
        upperBound = lowerBound;
        lowerBound = lowerBound - diff;
        return SeriesGenerator.generate(filteredSignals, lowerBound, upperBound, channels);
    }

    private float[] filterSignal(float[] signal, float samplingFrequency,
                                 float cutoffFrequencyHP, float cutoffFrequencyLP) {

        return BandPassFilter.filter(signal, samplingFrequency, cutoffFrequencyHP, cutoffFrequencyLP);
    }

    private float[][] filterSignals(float[][] signals,  float samplingFrequency,
                                    float cutoffFrequencyHP, float cutoffFrequencyLP){

        float[][] filteredSignals = new float[signals.length][];

        for (int i = 0; i < signals.length; ++i) {
            filteredSignals[i] = filterSignal(signals[i], samplingFrequency, cutoffFrequencyHP, cutoffFrequencyLP);
        }
        return filteredSignals;
    }

}
