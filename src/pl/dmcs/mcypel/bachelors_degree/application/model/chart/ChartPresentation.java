package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartMoveManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartPresentManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.DataGenerateManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ZoomManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 09.12.2016.
 */
public class ChartPresentation implements ChartPresentManager {

    private DataGenerateManager dataGenerator;
    private ChartMoveManager chartMoveWorker;
    private ZoomManager zoomWorker;


    public ChartPresentation(ECGSignal ecgSignal){
        dataGenerator = new DataGenerator(ecgSignal);
        chartMoveWorker = new ChartMoveWorker();
        zoomWorker = new ZoomWorker();
    }

}
