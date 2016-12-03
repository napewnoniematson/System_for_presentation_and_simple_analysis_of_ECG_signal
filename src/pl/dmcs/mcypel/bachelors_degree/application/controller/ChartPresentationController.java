package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ChartDataManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartPresentationController implements Initializable {

    private ChartDataManager chartDataManager;

    // TODO: 24.11.2016 generowanie wykresu w nowym watku

    @FXML
    private LineChart ecgLineChart;


    public void generateChart(ECGSignal ecgSignal){
        ecgLineChart.getData().add(chartDataManager.generateSeries(ecgSignal, 100000, 100300));

        /*for (int i =0 ; i <100; i++){
            System.out.println("From ecgsingal: " + ecgSignal.getChannel(0)[100000 + i]);
            System.out.println("From LineChart: " + ((XYChart.Series)ecgLineChart.getData().get(0)).getData().get(i));

        }*/

        System.out.println(this.getClass().toString());
        ((NumberAxis) ecgLineChart.getXAxis()).setLowerBound(100000.0);
        ((NumberAxis) ecgLineChart.getXAxis()).setUpperBound(100300.0);
        ((NumberAxis) ecgLineChart.getYAxis()).setLowerBound(100);
        ((NumberAxis) ecgLineChart.getYAxis()).setUpperBound(185);
    }

    public LineChart getSignal(){
        return ecgLineChart;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chartDataManager = new ChartDataManager();
    }
}

