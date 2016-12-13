package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.FolderChooser;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.SignalLoader;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.FolderChooseManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.SignalLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.save.ImageRecorder;
import pl.dmcs.mcypel.bachelors_degree.application.model.save.manager.ImageSaveManager;
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
    private ImageSaveManager imageRecorder;
    private FolderChooseManager folderChooseManager;
    @FXML
    private ChartPresentationController includedViewController;
    private ECGSignal ecgSignal;

    @FXML
    private void load(ActionEvent event) {
        folderChooseManager.chooseFolder();
        ecgSignal = loadManager.loadSignal(folderChooseManager); // returns ECGSignal
        includedViewController.runManager(ecgSignal);
        System.out.println("Name: " + loadManager.loadPatientData(folderChooseManager).getName());
        System.out.println("Surname: " + loadManager.loadPatientData(folderChooseManager).getSurname());
    }

    @FXML
    private void save() {
        System.out.println("save");
        imageRecorder.save(null, includedView.getCenter());
    }

    @FXML
    private void print() {
        System.out.println("print");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewManager = new ViewManager();
        loadManager = new SignalLoader();
        folderChooseManager = new FolderChooser();
        imageRecorder = new ImageRecorder();
    }
}
