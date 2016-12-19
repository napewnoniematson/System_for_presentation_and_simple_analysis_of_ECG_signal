package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartMoveManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartPresentManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ZoomManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.util.List;

/**
 * Created by Matson on 09.12.2016.
 */
public class ChartPresentation implements ChartPresentManager {

    private ChartSeriesManager dataGenerator;
    private ChartMoveManager chartMoveWorker;
    private ZoomManager zoomWorker;
    private List<XYChart.Series> currentSeries;
    private int channelNumber = 0;

    public ChartPresentation(ECGSignal ecgSignal, int lowerBound, int upperBound, int channelNumber){
        this.channelNumber = channelNumber;
        dataGenerator = new ChartSeriesProvider(ecgSignal);
        currentSeries = dataGenerator.generate(lowerBound, upperBound, channelNumber);
        chartMoveWorker = new ChartMoveWorker(ecgSignal, lowerBound, upperBound, channelNumber, currentSeries);
//        zoomWorker = new ZoomWorker();
    }


    @Override
    public List<XYChart.Series> previous() {
        return chartMoveWorker.previous();
    }

    @Override
    public List<XYChart.Series> next() {
        return chartMoveWorker.next();
    }

    @Override
    public void setBounds(int lowerBound, int upperBound) {
        chartMoveWorker.setBounds(lowerBound, upperBound);
    }

    @Override
    public List<XYChart.Series> generate(int lowerBound, int upperBound) {
        List<XYChart.Series> series;

        if (lowerBound < upperBound){
            series = dataGenerator.generate(lowerBound, upperBound, channelNumber);
            setBounds(lowerBound, upperBound);
        }else {
            series = dataGenerator.generate(upperBound, lowerBound, channelNumber);
            setBounds(upperBound, lowerBound);
        }
        return series;
    }
}
