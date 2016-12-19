package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matson on 09.12.2016.
 */
public final class SeriesGenerator {

    public static List<XYChart.Series> generate(ECGSignal ecgSignal, int lowerBound, int upperBound, int channelNumber){
        XYChart.Series series;
        List<XYChart.Series> seriesList = new ArrayList<>();
        for (int i = 0; i < channelNumber; ++i){
            series = new XYChart.Series();
            series.setName("Channel " + i);
            for (int j = lowerBound; j < upperBound; ++j) {
                series.getData().add(new XYChart.Data(j, ecgSignal.getChannel(i)[j]));
            }
            seriesList.add(series);
        }
        return seriesList;
    }


}
