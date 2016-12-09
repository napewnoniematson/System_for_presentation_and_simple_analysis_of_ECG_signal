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
    private int lowerBound = 0;
    private int upperBound = 300;


    public ChartPresentation(ECGSignal ecgSignal){
        dataGenerator = new ChartSeriesProvider(ecgSignal);
        createCurrentSeries();
        chartMoveWorker = new ChartMoveWorker();
        zoomWorker = new ZoomWorker();
    }

    private void createCurrentSeries(){
        currentSeries = dataGenerator.generate();
    }


}
