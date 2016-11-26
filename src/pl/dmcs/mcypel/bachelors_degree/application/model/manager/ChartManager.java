package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableIntegerArray;
import javafx.collections.ObservableList;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Line;
import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Matson on 20.11.2016.
 */
public class ChartManager {


    private ECGSignal ecgSignal; // chyba ze nie musze tych pol posiadac
//    private LineChart lineChart;

    public ChartManager(){}

    public ChartManager(LineChart lineChart, ECGSignal ecgSignal){
//        this.lineChart = lineChart;
        this.ecgSignal = ecgSignal;
    }

    public void generateChart(LineChart lineChart){
        ObservableList<XYChart.Series> chartData;
        XYChart.Series<Integer, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < 10; ++i) {
            series.getData().add(new XYChart.Data(i, i));
        }
        chartData = FXCollections.observableArrayList(Collections.singleton(series));
        lineChart.setData(chartData);
//        lineChart.getData().add(prepareChartData());
        System.out.println("Wykreślony Chart");
    }


    public XYChart.Series prepareChartData(){
        // TODO: 23.11.2016 sparametryzowac metode, zrobic bardziej uniwersalna, lowerbound,upperbound
        XYChart.Series chartData = new XYChart.Series();
        chartData.setName("ChartData");
        for(int i = 0; i < 10; ++i){
            chartData.getData().add(new XYChart.Data(i, /*ecgSignal.getChannel(0)[i]*/ i));
        }
        return chartData;
    }

    //zooming method


}
