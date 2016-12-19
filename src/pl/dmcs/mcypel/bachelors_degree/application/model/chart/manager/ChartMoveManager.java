package pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager;

import javafx.scene.chart.XYChart;

import java.util.List;

/**
 * Created by Matson on 08.12.2016.
 */
public interface ChartMoveManager {

    List<XYChart.Series> previous();

    List<XYChart.Series> next();

    // TODO: 12.12.2016 moze tu byc setbounds?
    void setBounds(int lowerBound, int upperBound);
}
