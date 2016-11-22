package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartPresentation implements Initializable {

    private int counter = 0;
    @FXML
    private LineChart lineChart;


    public int getCounterTest(){
        return counter;
    }

    @FXML
    private void onChartClickTest(){
        counter++;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

