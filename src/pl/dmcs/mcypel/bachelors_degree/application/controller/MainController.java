package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.DialogPresenter;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.FolderChooser;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.SignalLoader;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.FolderChooseManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.manager.SignalLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.save.ImageRecorder;
import pl.dmcs.mcypel.bachelors_degree.application.model.save.manager.ImageSaveManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;
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
    private SignalLoadManager loadManager;
    private ImageSaveManager imageRecorder;
    private FolderChooseManager folderChooseManager;
    @FXML
    private ChartPresentationController includedViewController;
    private ECGSignal ecgSignal;

    @FXML
    private void load(ActionEvent event) {
        try {
            folderChooseManager.chooseFolder();
            ecgSignal = loadManager.loadSignal(folderChooseManager); // returns ECGSignal
            includedViewController.runManager(ecgSignal);
            System.out.println("Name: " + loadManager.loadPatientData(folderChooseManager).getName());
            System.out.println("Surname: " + loadManager.loadPatientData(folderChooseManager).getSurname());
        } catch (IOException e) {
            DialogPresenter.showInfoDialog("Open file", null, "To see ECG signal you need to choose path to right folder");
        }
    }

    @FXML
    private void save() {
        System.out.println("save");
        imageRecorder.save(null, includedView.getCenter());
    }

    @FXML
    private void print() {
        System.out.println("print");

        System.out.println(includedView.getCenter().managedProperty().get());
        System.out.println(includedView.getLeft().managedProperty().get());
        System.out.println(includedView.getRight().managedProperty().get());
        System.out.println(includedView.managedProperty().get());

        /*System.out.println("getCenter");
        System.out.println(((Button) includedView.getLeft()).getWidth());
        System.out.println(includedView.getLayoutX());
        System.out.println(includedView.getCenter().getClass());
        System.out.println(includedView.getCenter().translateXProperty().get());
        System.out.println(includedView.getCenter().getTranslateX());
        System.out.println(includedView.getCenter().getLayoutX());
        System.out.println(includedView.getCenter().translateYProperty().get());
        System.out.println(includedView.getCenter().getTranslateY());
        System.out.println(includedView.getCenter().getLayoutY());
        System.out.println("getRight");
        System.out.println(includedView.getRight().getClass());
        System.out.println(includedView.getRight().translateXProperty().get());
        System.out.println(includedView.getRight().getTranslateX());
        System.out.println(includedView.getRight().getLayoutX());
        System.out.println(includedView.getRight().translateYProperty().get());
        System.out.println(includedView.getRight().getTranslateY());
        System.out.println(includedView.getRight().getLayoutY());*/


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewManager = new ViewManager();
        loadManager = new SignalLoader();
        folderChooseManager = new FolderChooser();
        imageRecorder = new ImageRecorder();
    }
}
