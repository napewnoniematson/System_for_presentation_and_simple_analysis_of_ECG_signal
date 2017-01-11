package pl.dmcs.mcypel.bachelors_degree.application.utils.layout;

import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import org.gillius.jfxutils.chart.JFXChartUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matson on 11.01.2017.
 */
public final class ChartsCreator {

    // TODO: 11.01.2017 na razie useless
    public static List<LineChart> createCharts(int channels) {
        List<LineChart> charts = new ArrayList<>();
        for (int i = 0; i < channels; ++i) {
            LineChart lineChart = new LineChart(createxAxis(), createyAxis());
            lineChart.setAnimated(false);
            lineChart.setCreateSymbols(false);
            lineChart.setHorizontalGridLinesVisible(false);
            lineChart.setVerticalGridLinesVisible(false);
            lineChart.setMaxSize(1.7976931348623157E308, 1.7976931348623157E308);
            lineChart.setLegendVisible(false);
//            JFXChartUtil.setupZooming(lineChart);
            charts.add(lineChart);
        }
        return charts;
    }

    private static NumberAxis createxAxis() {
        NumberAxis axis = new NumberAxis();
        axis.setAutoRanging(false);
        axis.setSide(Side.BOTTOM);
        axis.setTickLabelRotation(90);
        axis.setTickMarkVisible(false);
        return axis;
    }

    private static NumberAxis createyAxis() {
        NumberAxis axis = new NumberAxis();
        axis.setAutoRanging(false);
        axis.setSide(Side.LEFT);
        axis.setTickMarkVisible(false);
        axis.setLowerBound(100);
        axis.setUpperBound(230);
        return axis;
    }

    private static void setZooming(LineChart chart, boolean value) {
        if (value) {
            JFXChartUtil.setupZooming(chart);
        }
    }
}
