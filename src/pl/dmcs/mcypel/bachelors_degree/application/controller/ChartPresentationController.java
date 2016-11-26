package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ChartManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartPresentationController implements Initializable {

    private ChartManager chartManager;

    // TODO: 24.11.2016 generowanie wykresu w nowym watku

//    private int counter = 0;
    @FXML
    private LineChart lineChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chartManager = new ChartManager();
    }
}

