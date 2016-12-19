package pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager;

import javafx.scene.chart.XYChart;
import java.util.List;

/**
 * Created by Matson on 08.12.2016.
 */
public interface ChartSeriesManager {

    List<XYChart.Series> generate(int lowerBound, int upperBound, int channelNumber);

}
