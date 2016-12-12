package pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager;

import javafx.scene.chart.XYChart;

/**
 * Created by Matson on 08.12.2016.
 */
public interface ChartSeriesManager {

//    XYChart.Series generate();

    XYChart.Series generate(int lowerBound, int upperBound);

}
