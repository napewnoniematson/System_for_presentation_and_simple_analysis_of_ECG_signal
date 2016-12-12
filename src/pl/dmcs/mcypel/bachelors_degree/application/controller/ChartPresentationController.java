package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

    public void runManager(ECGSignal ecgSignal) {
        chartPresenter = new ChartPresentation(ecgSignal, 100000, 101000);
    }

    public void generateOnLoad(){

    }

    @FXML
    private void next() {
        System.out.println("nextbutton clicked");
        chartPresenter.next();
    }

    @FXML
    private void previous() {
        System.out.println("previous clicked");
        chartPresenter.previous();
    }

    @FXML
    private void generate() {
        System.out.println("generate");
        int lowerBound = getLowerBoundFromTextEdit();
        int upperBound = getUpperBoundFromTextEdit();
        XYChart.Series series = chartPresenter.generate(lowerBound, upperBound);;
        ecgLineChart.getData().clear();
        ecgLineChart.getData().add(series);
    }

    // TODO: 12.12.2016 zabezpieczenie przed literkami
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
    }
}

