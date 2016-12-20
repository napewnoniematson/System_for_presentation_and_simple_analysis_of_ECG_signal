package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matson on 09.12.2016.
 */
public final class SeriesGenerator {
    // TODO: 20.12.2016 przeniesc jako wewnetrzna klasa w chartseriesprovider, albo jako inna metoda w tej klasie, albo zostawic static
    public static ObservableList<XYChart.Series> generate(ECGSignal ecgSignal, int lowerBound, int upperBound,
                                                          int channels){
        XYChart.Series series;
        List<XYChart.Series> seriesList = new ArrayList<>();
        for (int i = 0; i < channels; ++i){
            series = new XYChart.Series();
            series.setName("Channel " + i);
            for (int j = lowerBound; j < upperBound; ++j) {
                series.getData().add(new XYChart.Data(j, ecgSignal.getChannel(i)[j] * 25.5f));
            }
            seriesList.add(series);
        }
        return FXCollections.observableList(seriesList);
    }


}
