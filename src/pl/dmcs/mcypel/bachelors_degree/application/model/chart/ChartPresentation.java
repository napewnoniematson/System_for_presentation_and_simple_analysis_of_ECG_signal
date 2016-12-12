package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartMoveManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartPresentManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ZoomManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 09.12.2016.
 */
public class ChartPresentation implements ChartPresentManager {

    private ChartSeriesManager dataGenerator;
    private ChartMoveManager chartMoveWorker;
    private ZoomManager zoomWorker;
    private XYChart.Series currentSeries;

    public ChartPresentation(ECGSignal ecgSignal, int lowerBound, int upperBound){
        dataGenerator = new ChartSeriesProvider(ecgSignal);
        currentSeries = dataGenerator.generate(lowerBound, upperBound);
        chartMoveWorker = new ChartMoveWorker(ecgSignal, lowerBound, upperBound, currentSeries);
//        zoomWorker = new ZoomWorker();
    }


    @Override
    public XYChart.Series previous() {
        return chartMoveWorker.previous();
    }

    @Override
    public XYChart.Series next() {
        return chartMoveWorker.next();
    }

    @Override
    public XYChart.Series generate(int lowerBound, int upperBound) {
        XYChart.Series series;

        if (lowerBound < upperBound){
            series = dataGenerator.generate(lowerBound, upperBound);
        }else {
            series = dataGenerator.generate(upperBound, lowerBound);
        }

        return series;
    }
}
