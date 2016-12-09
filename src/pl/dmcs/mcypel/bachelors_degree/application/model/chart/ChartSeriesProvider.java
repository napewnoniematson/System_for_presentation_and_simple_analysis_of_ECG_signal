package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 08.12.2016.
 */
public class ChartSeriesProvider implements ChartSeriesManager {

    private ECGSignal ecgSignal;
    private int lowerBound = 0;
    private int upperBound = 300;
//    private int diff = 300;

    public ChartSeriesProvider(ECGSignal ecgSignal) {
        this.ecgSignal = ecgSignal;
    }

    // TODO: 09.12.2016 Channel do ogarniecia
    // TODO: 09.12.2016 mozliwe zeby zwracac liste serii bo kilka channeli
    @Override
    public XYChart.Series generate() {
        return SeriesGenerator.generate(ecgSignal, lowerBound, upperBound, 0);
    }

    @Override
    public XYChart.Series generate(int lowerBound, int upperBound) {
        return SeriesGenerator.generate(ecgSignal, lowerBound, upperBound, 0);
    }
}
