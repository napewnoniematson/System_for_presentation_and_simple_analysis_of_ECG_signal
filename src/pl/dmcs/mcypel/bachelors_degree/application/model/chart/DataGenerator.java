package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.DataGenerateManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 08.12.2016.
 */
public class DataGenerator implements DataGenerateManager {

    private ECGSignal ecgSignal;

    public DataGenerator(ECGSignal ecgSignal) {
        this.ecgSignal = ecgSignal;
    }


    @Override
    public XYChart.Series generate() {
        return null;
    }

    @Override
    public XYChart.Series generate(int lowerSample, int upperSample) {
        return null;
    }
}
