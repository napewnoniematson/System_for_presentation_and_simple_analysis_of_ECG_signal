package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.ECGSignal;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ChartManager;
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
    private ChartPresentationController chartPresentationController;
//    @FXML
//    private LineChart<Number, Number> ecgLineChart;

    @FXML
    private void onLoadBtnClick(ActionEvent event){
        // TODO: 23.11.2016 dodatkowy button do przechodzenia na chart bo jak wroce do load to musze otwierac plik na nowo zamiast miec wykres
        ECGSignal ecgSignal = loadManager.load(); // returns ECGSignal
        viewManager.changeIncludedView(includedView, CHART_PRESENTATION_FXML_PATH);
        LineChart lineChart = (LineChart)((BorderPane) includedView.getChildren().get(0)).getCenter();
        lineChart.getData().add(new ChartManager(lineChart, ecgSignal).prepareChartData());

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