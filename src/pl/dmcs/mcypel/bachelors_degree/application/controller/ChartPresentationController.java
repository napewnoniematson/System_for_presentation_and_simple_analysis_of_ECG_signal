package pl.dmcs.mcypel.bachelors_degree.application.controller;

import com.sun.deploy.jardiff.JarDiff;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import jdk.internal.org.objectweb.asm.util.ASMifier;
import org.gillius.jfxutils.chart.JFXChartUtil;
import pl.dmcs.mcypel.bachelors_degree.AppStart;
import pl.dmcs.mcypel.bachelors_degree.application.model.DialogPresenter;
import pl.dmcs.mcypel.bachelors_degree.application.model.Logger;
import pl.dmcs.mcypel.bachelors_degree.application.model.SignalFilter;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.ChartSeriesProvider;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartPresentationController implements Initializable {


    private final static int BOUND_DIFFERENCE = 300;

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

    private ChartSeriesManager seriesManager;
    private ObservableList<XYChart.Series> series;

    public void runManager(ECGSignal ecgSignal, int channels) {
        seriesManager = new ChartSeriesProvider(ecgSignal, channels);
        int startBound = SignalFilter.filter(ecgSignal);
        series = seriesManager.generateSeries(startBound, startBound + BOUND_DIFFERENCE);
        insertData(series);
        yAxis.setLowerBound(2550);
        yAxis.setUpperBound(6400);
    }

    @FXML
    private void next() {
        series = seriesManager.getNextSeries();
        insertData(series);
    }

    @FXML
    private void previous() {
        series = seriesManager.getPreviousSeries();
        insertData(series);
    }

    @FXML
    private void generate() {
        try{
            series = seriesManager.generateSeries(getLowerBoundFromTextEdit(), getUpperBoundFromTextEdit());
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

    // TODO: 20.12.2016 ogarnac to
    private void insertData(List<XYChart.Series> series){
        ecgLineChart.getData().clear();
        int lowerBound = Integer.parseInt(((XYChart.Data) series.get(0).getData()
                .get(0)).getXValue().toString());
        int upperBound = Integer.parseInt(((XYChart.Data) series.get(0).getData().
                get(series.get(0).getData().size() - 1)).getXValue().toString());
        xAxis.setLowerBound(lowerBound);
        xAxis.setUpperBound(upperBound);
        for (XYChart.Series serie : series)
            ecgLineChart.getData().add(serie);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXChartUtil.setupZooming(ecgLineChart);
    }
}

