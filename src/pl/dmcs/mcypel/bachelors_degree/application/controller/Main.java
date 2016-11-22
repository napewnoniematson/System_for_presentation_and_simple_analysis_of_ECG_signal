package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.LoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 19.11.2016.
 */
public class Main implements Initializable{

    private static final String CHART_PRESENTATION_FXML_PATH = "../../view/included/chart_presentation.fxml";
    private static final String PATIENT_DATA_FXML_PATH = "../../view/included/patient_data.fxml";
    private static final String PARAMETERS_FXML_PATH = "../../view/included/parameters.fxml";

    @FXML
    private BorderPane includedView;
    private ViewManager viewManager;
    private LoadManager loadManager;
    @FXML
    private ChartPresentation chartPresentation;


    @FXML
    private void onLoadBtnClick(ActionEvent event){
        loadManager.load(); // returns ECGSignal
        viewManager.changeIncludedView(includedView, CHART_PRESENTATION_FXML_PATH);
        LineChart lineChart = (LineChart)((BorderPane) includedView.getChildren().get(0)).getCenter();
        if (lineChart == null)
            System.out.println("jest null");
        else
            System.out.println(lineChart.getHeight());

        int x = chartPresentation.getCounterTest();
        System.out.println(x);
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
