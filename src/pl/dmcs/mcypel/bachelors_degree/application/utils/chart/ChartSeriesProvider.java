package pl.dmcs.mcypel.bachelors_degree.application.utils.chart;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.utils.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 08.12.2016.
 */
public class ChartSeriesProvider implements ChartSeriesManager {

    private ECGSignal ecgSignal;
    private ObservableList<XYChart.Series> currentSeries;
    private ObservableList<XYChart.Series> previousSeries, nextSeries;
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

        diff = this.upperBound - this.lowerBound;
        previousSeries = SeriesGenerator.generate(ecgSignal, this.lowerBound - diff, this.lowerBound, channels);
        currentSeries = SeriesGenerator.generate(ecgSignal, this.lowerBound, this.upperBound, channels);
        nextSeries = SeriesGenerator.generate(ecgSignal, this.upperBound, this.upperBound + diff, channels);
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
        previousSeries = SeriesGenerator.generate(ecgSignal, lowerBound - diff, lowerBound, channels);
        return currentSeries;
    }
}
