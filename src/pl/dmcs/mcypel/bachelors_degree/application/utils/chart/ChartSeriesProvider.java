package pl.dmcs.mcypel.bachelors_degree.application.utils.chart;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.utils.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.utils.filter.LowPassFilter;

/**
 * Created by Matson on 08.12.2016.
 */
public class ChartSeriesProvider implements ChartSeriesManager {

    private ECGSignal ecgSignal;
    private ObservableList<XYChart.Series> currentSeries;
    private int lowerBound, upperBound, diff;
    private int channels;
    private float[][] filteredSignals;

    public ChartSeriesProvider(ECGSignal ecgSignal, int channels) {
        this.ecgSignal = ecgSignal;
        this.channels = channels;
        filteredSignals = filterSignals(ecgSignal.getAllData(), ecgSignal.getSamplingFrequency(), 50);
        filteredSignals = filterSignals(filteredSignals, ecgSignal.getSamplingFrequency(), 30);
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

    private float[] filterSignal(float[] signal, float samplingFrequency, float cutoffFrequency) {
        return LowPassFilter.filter(signal, samplingFrequency, cutoffFrequency);
    }

    private float[][] filterSignals(float[][] signals, float samplingFrequency, float cutoffFrequency){

        float[][] filteredSignals = new float[signals.length][];

        for (int i = 0; i < signals.length; ++i) {
            filteredSignals[i] = filterSignal(signals[i], samplingFrequency, cutoffFrequency);
        }
        return filteredSignals;
    }

}
