package pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import java.util.List;

/**
 * Created by Matson on 08.12.2016.
 */
public interface ChartSeriesManager {

    ObservableList<XYChart.Series> generateSeries(int lowerBound, int upperBound);

    ObservableList<XYChart.Series> getNextSeries();

    ObservableList<XYChart.Series> getPreviousSeries();


}
