package pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager;

import javafx.scene.chart.XYChart;

/**
 * Created by Matson on 09.12.2016.
 */
public interface ChartPresentManager extends ChartMoveManager, ZoomManager {

    XYChart.Series generate(int lowerBound, int upperBound);

}
