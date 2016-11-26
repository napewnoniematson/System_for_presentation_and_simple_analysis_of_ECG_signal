package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ChartManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.LoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ViewManager;

import java.io.IOException;
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

    @FXML
    private void onLoadBtnClick(ActionEvent event){
//        ECGSignal ecgSignal = loadManager.load(); // returns ECGSignal

//        LineChart lineChart = (LineChart)((BorderPane) includedView.getChildren().get(0)).getCenter();
//        lineChart.getData().add(new ChartManager(lineChart, ecgSignal).prepareChartData());
        if (includedViewController == null)
            System.out.println("jest null");
        else
            System.out.println("nie jest null");
    }

    @FXML
    private void onChartBtnClick(ActionEvent event){
//        viewManager.changeIncludedView(includedView, CHART_PRESENTATION_FXML_PATH);
//        po zmianie widoku trace jakby kontakt z ecgLineChartem?
        includedViewController.generateChart();
//        przetestowac jak sie argumenty zmieniaja
    }

    @FXML
    private void onDataBtnClick(ActionEvent event){
        viewManager.changeIncludedView(includedView, PATIENT_DATA_FXML_PATH);
    }

    @FXML
    private void onParametersBtnClick(ActionEvent event){
        viewManager.changeIncludedView(includedView, PARAMETERS_FXML_PATH);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewManager = new ViewManager();
        loadManager = new LoadManager();
    }
}
