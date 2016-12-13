package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.ChartPresentation;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartPresentManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartPresentationController implements Initializable {

    private ChartPresentManager chartPresenter;

    // TODO: 24.11.2016 generowanie wykresu w nowym watku
// TODO: 12.12.2016 filtr ktory zwroci lower/upper bound do generowania startowego
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
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;


    public void runManager(ECGSignal ecgSignal) {
        chartPresenter = new ChartPresentation(ecgSignal, 100000, 101000);
        generateOnLoad();
    }

    private void generateOnLoad(){
        System.out.println("generateOnLoad");
        XYChart.Series series = chartPresenter.generate(100000, 101000);
        insertData(series);
        yAxis.setLowerBound(100);
        yAxis.setUpperBound(200);
    }

    @FXML
    private void next() {
        System.out.println("nextbutton clicked");
        XYChart.Series series = chartPresenter.next();
        insertData(series);
    }

    // TODO: 12.12.2016 onKeyPressed = "#next_test"
//    @FXML
//    private void next_test(KeyEvent keyEvent){
//        if (keyEvent.getCode() == KeyCode.RIGHT){
//            next();
//            keyEvent.consume();
//        }
//    }


    @FXML
    private void previous() {
        System.out.println("previous clicked");
        XYChart.Series series = chartPresenter.previous();
        insertData(series);
    }

    // TODO: 12.12.2016 zostaja stare currentSeries, dlatego raz jak sie kliknie next to wczytuje stare
    @FXML
    private void generate() {
        System.out.println("generate");
        int lowerBound = getLowerBoundFromTextEdit();
        int upperBound = getUpperBoundFromTextEdit();
        XYChart.Series series = chartPresenter.generate(lowerBound, upperBound);
        insertData(series);
    }


    // TODO: 12.12.2016 zabezpieczenie przed literkami
    private int getLowerBoundFromTextEdit() {
        return Integer.parseInt(lowerBoundTextField.getText());
    }

    private int getUpperBoundFromTextEdit() {
        return Integer.parseInt(upperBoundTextField.getText());
    }


    private void setXAxisBounds(int lowerBound, int upperBound){
        xAxis.setLowerBound(lowerBound);
        xAxis.setUpperBound(upperBound);
    }

    private void insertData(XYChart.Series series){
        ecgLineChart.getData().clear();
        int lowerBound = Integer.parseInt(((XYChart.Data) series.getData()
                .get(0)).getXValue().toString());
        int upperBound = Integer.parseInt(((XYChart.Data) series.getData().
                get(series.getData().size() - 1)).getXValue().toString());
        setXAxisBounds(lowerBound, upperBound);
        ecgLineChart.getData().add(series);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

