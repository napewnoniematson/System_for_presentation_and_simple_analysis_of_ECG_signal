package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.LoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 19.11.2016.
 */
public class MainController implements Initializable{

    // TODO: 24.11.2016 bindowanie + propertasy do wyswietlania danych pacjenta ??

    private static final String CHART_PRESENTATION_FXML_PATH = "../../view/included/chart_presentation.fxml";
    private static final String PATIENT_DATA_FXML_PATH = "../../view/included/patient_data.fxml";
    private static final String PARAMETERS_FXML_PATH = "../../view/included/parameters.fxml";

    @FXML
    private BorderPane includedView;
    private ViewManager viewManager;
    private LoadManager loadManager;
    @FXML
    private ChartPresentationController includedViewController;
//    @FXML
//    private LineChart<Number, Number> ecgLineChart;

    private ECGSignal ecgSignal;

    @FXML
    private void loadECGSignalFromFile(ActionEvent event) {

        ecgSignal = loadManager.load(); // returns ECGSignal
//        LineChart lineChart = (LineChart)((BorderPane) includedView.getChildren().get(0)).getCenter();
//        lineChart.getData().add(new ChartDataManager(lineChart, ecgSignal).prepareChartData());
        if (includedViewController == null)
            System.out.println("jest null");
        else
            System.out.println("nie jest null");
    }



    private ObservableList<XYChart.Data> temporaryChart(){
        BorderPane borderPane = (BorderPane)includedView.getChildren().get(0);
        System.out.println("BorderPane: " + borderPane.toString());
        LineChart lineChart = (LineChart) borderPane.getCenter();
        System.out.println("LineChart: " + lineChart.toString());
        XYChart.Series series = (XYChart.Series) lineChart.getData().get(0);
        System.out.println("Series " + series.toString());
        return (ObservableList<XYChart.Data>) series.getData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewManager = new ViewManager();
        loadManager = new LoadManager();
    }
}
