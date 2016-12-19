package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.util.List;

/**
 * Created by Matson on 08.12.2016.
 */
public class ChartSeriesProvider implements ChartSeriesManager {

    private ECGSignal ecgSignal;

    public ChartSeriesProvider(ECGSignal ecgSignal) {
        this.ecgSignal = ecgSignal;
    }

    // TODO: 09.12.2016 Channel do ogarniecia
    // TODO: 09.12.2016 mozliwe zeby zwracac liste serii bo kilka channeli

    @Override
    public List<XYChart.Series> generate(int lowerBound, int upperBound, int channelNumber) {
        return SeriesGenerator.generate(ecgSignal, lowerBound, upperBound, channelNumber);
    }
}
