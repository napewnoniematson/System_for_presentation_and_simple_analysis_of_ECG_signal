package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import org.gillius.jfxutils.chart.ChartZoomManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 18.01.2017.
 */
public class ChartPresentationController implements Initializable {


    @FXML
    private StackPane ecgPane, peaksPane;
    @FXML
    private Rectangle ecgRectangle, peaksRectangle;
    @FXML
    private LineChart ecgLineChart, ecgLineChartPeaks;
    @FXML
    private NumberAxis xAxis, xAxisP;
    @FXML
    private NumberAxis yAxis, yAxisP;



    public LineChart getEcgLineChart() {
        return ecgLineChart;
    }

    public LineChart getEcgLineChartPeaks() {
        return ecgLineChartPeaks;
    }

    public NumberAxis getxAxis() {
        return xAxis;
    }

    public NumberAxis getxAxisP() {
        return xAxisP;
    }

    public NumberAxis getyAxis() {
        return yAxis;
    }

    public NumberAxis getyAxisP() {
        return yAxisP;
    }

    public void runZooming() {
        ChartZoomManager ecgZoomManager = new ChartZoomManager(ecgPane, ecgRectangle, ecgLineChart );
        ecgZoomManager.setZoomAnimated(false);
        ecgZoomManager.setMouseWheelZoomAllowed(false);
        ecgZoomManager.start();

        ChartZoomManager peaksZoomManager = new ChartZoomManager(peaksPane, peaksRectangle, ecgLineChartPeaks);
        peaksZoomManager.setZoomAnimated(false);
        peaksZoomManager.setMouseWheelZoomAllowed(false);
        peaksZoomManager.start();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
