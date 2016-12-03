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
public class ChartDataManager {
// TODO: 30.11.2016 buffory danych przed i po

    private int lowerSample = 0;
    private int upperSample = 0;
    private int difference = 300; //jakies ify gdyby mialo wyjsc za zakres
    private XYChart.Series previousSeries, currentSeries, nextSeries;

    public ChartDataManager() {
    }

    // TODO: 30.11.2016 ify dla series

    public XYChart.Series generateSeries(ECGSignal ecgSignal, int lowerSample, int upperSample){
//        difference = upperSample - lowerSample;
        System.out.println(this.getClass().toString());

        return prepareChartSeries(ecgSignal,lowerSample,upperSample,0);

    }

    private XYChart.Series preparePreviousSeries(int lowerSample, int upperSample, ECGSignal ecgSignal){


        return null;
    }

    private XYChart.Series prepareCurrentSeries(){


        return null;
    }

    private XYChart.Series prepareNextSeries(){
        lowerSample = upperSample;
        upperSample += difference;
//        prepareChartSeries()
        return null;
    }




    //wstepnie channel = 0
    private XYChart.Series prepareChartSeries(ECGSignal ecgSignal, int lowerSample, int upperSample, int channel) {
        // TODO: 27.11.2016 dodaja sie kolejne serie zamiast nadpisywac, upper/lowerbound
        XYChart.Series chartData = new XYChart.Series();
        chartData.setName("Channel " + channel);
        for (int i = lowerSample; i < upperSample; ++i) {
            chartData.getData().add(new XYChart.Data(i, ecgSignal.getChannel(channel)[i]));
        }
        return chartData;
    }


    //zooming method



        /*public void generateChart(LineChart lineChart, ECGSignal ecgSignal){
        ObservableList<XYChart.Series> chartData;
        XYChart.Series<Integer, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < 10; ++i) {
            series.getData().add(new XYChart.Data(i, i));
        }
        chartData = FXCollections.observableArrayList(Collections.singleton(series));
        lineChart.setData(chartData);
//        System.out.println("Wykreślony Chart");
    }*/
}
