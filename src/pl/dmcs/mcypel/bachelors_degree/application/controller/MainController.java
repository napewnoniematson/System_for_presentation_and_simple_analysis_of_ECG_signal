package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.SignalLoader;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.SignalLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;
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
    private SignalLoadManager loadManager;
    @FXML
    private ChartPresentationController includedViewController;
    private ECGSignal ecgSignal;

    @FXML
    private void loadECGSignalFromFile(ActionEvent event) {
        ecgSignal = loadManager.loadSignal(); // returns ECGSignal
        includedViewController.runManager(ecgSignal);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewManager = new ViewManager();
        loadManager = new SignalLoader();
    }
}
