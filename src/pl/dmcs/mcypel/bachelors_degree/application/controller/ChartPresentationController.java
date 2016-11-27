package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.shape.Line;
import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ChartManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartPresentationController implements Initializable {

    private ChartManager chartManager;

    // TODO: 24.11.2016 generowanie wykresu w nowym watku

    @FXML
    private LineChart ecgLineChart;


    public void generateChart(ECGSignal ecgSignal){
        chartManager.generateChart(ecgLineChart, ecgSignal);
        ((NumberAxis) ecgLineChart.getXAxis()).setLowerBound(100000.0);
        ((NumberAxis) ecgLineChart.getXAxis()).setUpperBound(100500.0);
        ((NumberAxis) ecgLineChart.getYAxis()).setLowerBound(100);
        ((NumberAxis) ecgLineChart.getYAxis()).setUpperBound(185);
    }

    public LineChart getSignal(){
        return ecgLineChart;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chartManager = new ChartManager();
    }
}

