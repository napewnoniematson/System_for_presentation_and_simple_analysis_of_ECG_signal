package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.ChartPresentation;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartPresentManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ChartDataManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartPresentationController implements Initializable {

    private ChartPresentManager chartPresenter;

    // TODO: 24.11.2016 generowanie wykresu w nowym watku

    @FXML
    private LineChart ecgLineChart;
    @FXML
    private Button previousButton;
    @FXML
    private Button nextButton;
    @FXML
    private TextField lowerBoundTextField;
    @FXML
    private TextField upperBoundTextField;
    @FXML
    private Button generateButton;

    @FXML
    private void next() {
        System.out.println("nextbutton clicked");
    }

    @FXML
    private void previous() {
        System.out.println("previous clicked");
    }



    private int getLowerBoundFromTextEdit() {
        return Integer.parseInt(lowerBoundTextField.getText());
    }

    private int getUpperBoundFromTextEdit() {
        return Integer.parseInt(upperBoundTextField.getText());
    }

    public void generateChart(ECGSignal ecgSignal){
        /*ecgLineChart.getData().add(chartDataManager.generateSeries(ecgSignal, 100000, 100300));
        ((NumberAxis) ecgLineChart.getXAxis()).setLowerBound(100000.0);
        ((NumberAxis) ecgLineChart.getXAxis()).setUpperBound(100300.0);
        ((NumberAxis) ecgLineChart.getYAxis()).setLowerBound(100);
        ((NumberAxis) ecgLineChart.getYAxis()).setUpperBound(185);*/
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chartPresenter = new ChartPresentation();
    }
}

