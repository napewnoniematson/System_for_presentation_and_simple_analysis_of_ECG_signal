package pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager;

import javafx.scene.chart.XYChart;

import java.util.List;

/**
 * Created by Matson on 09.12.2016.
 */
public interface ChartPresentManager extends ChartMoveManager, ZoomManager {

    List<XYChart.Series> generate(int lowerBound, int upperBound);

}
