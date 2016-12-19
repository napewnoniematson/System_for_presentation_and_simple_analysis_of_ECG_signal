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
import org.gillius.jfxutils.chart.JFXChartUtil;
import pl.dmcs.mcypel.bachelors_degree.application.model.DialogPresenter;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.ChartPresentation;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartPresentManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.net.URL;
import java.util.List;
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
    private List<XYChart.Series> series;

    public void runManager(ECGSignal ecgSignal, int channelNumber) {
        chartPresenter = new ChartPresentation(ecgSignal, 100000, 100100, channelNumber);
        generateOnLoad();
    }

    private void generateOnLoad(){
        System.out.println("generateOnLoad");
        series = chartPresenter.generate(100000, 100100);
        insertData(series);
        yAxis.setLowerBound(100);
        yAxis.setUpperBound(200);
    }

    @FXML
    private void next() {
        series = chartPresenter.next();
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
        series = chartPresenter.previous();
        insertData(series);
    }

    // TODO: 12.12.2016 zostaja stare currentSeries, dlatego raz jak sie kliknie next to wczytuje stare
    // TODO: 15.12.2016 dac buttony do generowania na disable
    @FXML
    private void generate() {
        try{
            int lowerBound = getLowerBoundFromTextEdit();
            int upperBound = getUpperBoundFromTextEdit();
            series = chartPresenter.generate(lowerBound, upperBound);
            insertData(series);
        }catch (IllegalArgumentException e){
            DialogPresenter.showInfoDialog("Generate info", "Wrong parameter", "Bound must be the natural number");
        }

    }

    private int getBoundFromTextEdit(TextField textField) {
        int bound = Integer.parseInt(textField.getText());
        if (bound < 0)
            throw new IllegalArgumentException("Bound less than zero");
        return bound;
    }

    private int getLowerBoundFromTextEdit() {
        return getBoundFromTextEdit(lowerBoundTextField);
    }

    private int getUpperBoundFromTextEdit() {
        return getBoundFromTextEdit(upperBoundTextField);
    }


    private void setXAxisBounds(int lowerBound, int upperBound){
        xAxis.setLowerBound(lowerBound);
        xAxis.setUpperBound(upperBound);
    }

    private void insertData(List<XYChart.Series> series){
        ecgLineChart.getData().clear();
        int lowerBound = Integer.parseInt(((XYChart.Data) series.get(0).getData()
                .get(0)).getXValue().toString());
        int upperBound = Integer.parseInt(((XYChart.Data) series.get(0).getData().
                get(series.get(0).getData().size() - 1)).getXValue().toString());
        setXAxisBounds(lowerBound, upperBound);
        for (XYChart.Series serie : series)
            ecgLineChart.getData().add(serie);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXChartUtil.setupZooming(ecgLineChart);
    }
}

