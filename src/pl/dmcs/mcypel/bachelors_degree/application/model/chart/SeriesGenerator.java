package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 09.12.2016.
 */
public final class SeriesGenerator {

    private SeriesGenerator(){};

    public static XYChart.Series generate(ECGSignal ecgSignal, int lowerBound, int upperBound, int channel){
        XYChart.Series series = new XYChart.Series();
        series.setName("Channel " + channel);
        for (int i = lowerBound; i < upperBound; ++i) {
            series.getData().add(new XYChart.Data(i, ecgSignal.getChannel(channel)[i]));
        }
        return series;
    }


}
