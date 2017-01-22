package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.beans.Observable;
import javafx.beans.value.ObservableBooleanValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import org.gillius.jfxutils.chart.ChartZoomManager;
import org.gillius.jfxutils.chart.JFXChartUtil;
import pl.dmcs.mcypel.bachelors_degree.application.utils.Math;
import pl.dmcs.mcypel.bachelors_degree.application.utils.filter.InputSignalFilter;
import pl.dmcs.mcypel.bachelors_degree.application.utils.layout.DialogPresenter;
import pl.dmcs.mcypel.bachelors_degree.application.utils.chart.ChartSeriesProvider;
import pl.dmcs.mcypel.bachelors_degree.application.utils.chart.manager.ChartSeriesManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.utils.qrs.Derivative;
import pl.dmcs.mcypel.bachelors_degree.application.utils.qrs.Detection;
import pl.dmcs.mcypel.bachelors_degree.application.utils.qrs.Integral;
import pl.dmcs.mcypel.bachelors_degree.application.utils.qrs.Power;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Matson on 21.11.2016.
 */
public class ChartManagementController implements Initializable {

    private final static float MIN_COEFF_ECG = 1.5f;
    private final static float MAX_COEFF_ECG = 1.5f;
    private final static float MIN_COEFF_PEAKS = 0.8f;
    private final static float MAX_COEFF_PEAKS = 1.2f;
    private final static int LOW_BOUND = 0;
    private final static int BOUND_DIFFERENCE = 300;
    private final static float LP_FREQ = 5;
    private final static float HP_FREQ = 15;

    @FXML
    private Button nextButton, previousButton, generateButton;
    @FXML
    private TextField lowerBoundTextField;
    @FXML
    private TextField upperBoundTextField;

    private LineChart ecgLineChart, ecgLineChartPeaks;
    private NumberAxis xAxis, xAxisP;
    private NumberAxis yAxis, yAxisP;

    private int lowerBound, upperBound;
    private float[][] filteredSignal, peaksSignal;

    private ChartSeriesManager seriesManager, peaksManager;

    public void runManager(ECGSignal ecgSignal, int channels, ChartPresentationController chartPresentationController) {
        initChartElements(chartPresentationController);
        float min = Math.min(ecgSignal.getChannel(0), 1000, 2000);
        float max = Math.max(ecgSignal.getChannel(0), 1000, 2000);
        filteredSignal = InputSignalFilter.filterSignals(ecgSignal.getAllData(), ecgSignal.getSamplingFrequency(), LP_FREQ, HP_FREQ, min, max);
        seriesManager = new ChartSeriesProvider(filteredSignal, channels);
        insertNormalData(seriesManager.generateSeries(LOW_BOUND, LOW_BOUND + BOUND_DIFFERENCE));

        peaksSignal = new float[channels][];
        for (int i = 0 ; i < channels; ++i) {
            float[] xd = Integral.integration(Power.power(Derivative.differentation(filteredSignal[i])));
            peaksSignal[i] = Detection.peaks(Detection.detection(xd));
        }
        peaksManager =  new ChartSeriesProvider(peaksSignal, channels);
        insertPeaksData(peaksManager.generateSeries(LOW_BOUND, LOW_BOUND + BOUND_DIFFERENCE));
    }

    @FXML
    private void next() {
        insertNormalData(seriesManager.getNextSeries());
        insertPeaksData(peaksManager.getNextSeries());
    }

    @FXML
    private void previous() {
        insertNormalData(seriesManager.getPreviousSeries());
        insertPeaksData(peaksManager.getPreviousSeries());
    }

    @FXML
    private void generate() {
        try{
            insertNormalData(seriesManager.generateSeries(getLowerBoundFromTextEdit(), getUpperBoundFromTextEdit()));
            insertPeaksData(peaksManager.generateSeries(getLowerBoundFromTextEdit(), getUpperBoundFromTextEdit()));
        }catch (IllegalArgumentException e){
            DialogPresenter.showInfoDialog("Generate info", "Wrong parameter", "Bound must be the natural number");
        }
    }

    @FXML
    private void resetZoomECG() {
        setAxis(xAxis, yAxis, MIN_COEFF_ECG, MAX_COEFF_ECG, filteredSignal);
    }

    @FXML
    private void resetZoomPeaks() {
        setAxis(xAxisP, yAxisP, MIN_COEFF_PEAKS, MAX_COEFF_PEAKS, peaksSignal);
    }

    private int getLowerBoundFromTextEdit() {
        return getBoundFromTextEdit(lowerBoundTextField);
    }

    private int getUpperBoundFromTextEdit() {
        return getBoundFromTextEdit(upperBoundTextField);
    }

    private int getBoundFromTextEdit(TextField textField) {
        int bound = Integer.parseInt(textField.getText());
        if (bound < 0)
            throw new IllegalArgumentException("Bound less than zero");
        return bound;
    }
    private void insertNormalData(List<XYChart.Series> series) {
        insertData(ecgLineChart, xAxis, yAxis, series, filteredSignal, MIN_COEFF_ECG, MAX_COEFF_ECG);
    }

    private void insertPeaksData(List<XYChart.Series> series) {
        insertData(ecgLineChartPeaks, xAxisP, yAxisP, series, peaksSignal, MIN_COEFF_PEAKS, MAX_COEFF_PEAKS);
    }

    // TODO: 20.12.2016 ogarnac to
    private void insertData(LineChart lineChart, NumberAxis xAxis, NumberAxis yAxis, List<XYChart.Series> series,
                            float[][] filteredSignal, float minCoefficient, float maxCoefficient){
        lineChart.getData().clear();
        lowerBound = Integer.parseInt(((XYChart.Data) series.get(0).getData()
                .get(0)).getXValue().toString());
        upperBound = Integer.parseInt(((XYChart.Data) series.get(0).getData().
                get(series.get(0).getData().size() - 1)).getXValue().toString());
        setAxis(xAxis, yAxis, minCoefficient, maxCoefficient, filteredSignal);
        for (XYChart.Series serie : series)
            lineChart.getData().add(serie);
    }

    private void setAxis(NumberAxis xAxis, NumberAxis yAxis, float minCoefficient, float maxCoefficient, float[][] filteredSignal) {
        xAxis.setLowerBound(lowerBound);
        xAxis.setUpperBound(upperBound);
        yAxis.setLowerBound(Math.min(filteredSignal[0], lowerBound, upperBound) * minCoefficient);
        yAxis.setUpperBound(Math.max(filteredSignal[0], lowerBound, upperBound) * maxCoefficient);
    }

    private void initChartElements(ChartPresentationController chartPresentationController) {
        ecgLineChart = chartPresentationController.getEcgLineChart();
        ecgLineChartPeaks = chartPresentationController.getEcgLineChartPeaks();
        xAxis = chartPresentationController.getxAxis();
        yAxis = chartPresentationController.getyAxis();
        xAxisP = chartPresentationController.getxAxisP();
        yAxisP = chartPresentationController.getyAxisP();
        chartPresentationController.runZooming();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

