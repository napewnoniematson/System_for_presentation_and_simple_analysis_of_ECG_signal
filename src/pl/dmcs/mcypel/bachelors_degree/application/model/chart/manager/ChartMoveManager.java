package pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager;

import javafx.scene.chart.XYChart;

/**
 * Created by Matson on 08.12.2016.
 */
public interface ChartMoveManager {

    XYChart.Series previous();

    XYChart.Series next();

    // TODO: 12.12.2016 moze tu byc setbounds?
    void setBounds(int lowerBound, int upperBound);
}
