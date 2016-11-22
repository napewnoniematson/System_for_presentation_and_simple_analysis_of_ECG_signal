package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.image.WritableImage;
import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;

/**
 * Created by Matson on 20.11.2016.
 */
public class ChartManager {


    private ECGSignal ecgSignal; // chyba ze nie musze tych pol posiadac
    private LineChart lineChart;

    public ChartManager(LineChart lineChart, ECGSignal ecgSignal){
        this.lineChart = lineChart;
        this.ecgSignal = ecgSignal;
    }



    public void prepareChartData(LineChart lineChart, ECGSignal ecgSignal){



    }














    /**
     * Gets the linechart's snapshot for image saving
     *
     * @param lineChart the linechart from where snapshot is taken
     * @return linechart's snapshot
     */
    public WritableImage getChartSnapshot(LineChart lineChart){
        return lineChart.snapshot(new SnapshotParameters(), null);

    }


}
