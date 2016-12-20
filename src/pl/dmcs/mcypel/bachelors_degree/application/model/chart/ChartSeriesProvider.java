package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.util.List;

/**
 * Created by Matson on 08.12.2016.
 */
public class ChartSeriesProvider implements ChartSeriesManager {

    private ECGSignal ecgSignal;
    private ObservableList<XYChart.Series> previousSeries, currentSeries, nextSeries;
    private int lowerBound, upperBound, diff;
    private int channels;

    public ChartSeriesProvider(ECGSignal ecgSignal, int channels) {
        this.ecgSignal = ecgSignal;
        this.channels = channels;
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

        diff = upperBound - lowerBound;
        previousSeries = SeriesGenerator.generate(ecgSignal, lowerBound - diff, lowerBound, channels);
        currentSeries = SeriesGenerator.generate(ecgSignal, lowerBound, upperBound, channels);
        nextSeries = SeriesGenerator.generate(ecgSignal, upperBound, upperBound + diff, channels);
        return currentSeries;
    }

    @Override
    public ObservableList<XYChart.Series> getNextSeries() {
        lowerBound = upperBound;
        upperBound = upperBound + diff;
        previousSeries = currentSeries;
        currentSeries = nextSeries;
        nextSeries = SeriesGenerator.generate(ecgSignal, upperBound, upperBound+diff, channels);
        return currentSeries;
    }

    @Override
    public ObservableList<XYChart.Series> getPreviousSeries() {
        upperBound = lowerBound;
        lowerBound = lowerBound - diff;
        nextSeries = currentSeries;
        currentSeries = previousSeries;
        previousSeries = SeriesGenerator.generate(ecgSignal, lowerBound, lowerBound - diff, channels);
        return currentSeries;
    }
}
