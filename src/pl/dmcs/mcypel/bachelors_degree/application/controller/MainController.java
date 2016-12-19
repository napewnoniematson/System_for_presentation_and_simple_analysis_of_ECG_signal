package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.ChoiceConfiguration;
import pl.dmcs.mcypel.bachelors_degree.application.model.DialogPresenter;
import pl.dmcs.mcypel.bachelors_degree.application.model.folder.FolderChooser;
import pl.dmcs.mcypel.bachelors_degree.application.model.load.SignalLoader;
import pl.dmcs.mcypel.bachelors_degree.application.model.folder.manager.FolderChooseManager;
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
            folderChooseManager.chooseOpenFolder(null);
            loadManager = new SignalLoader(folderChooseManager);
            ecgSignal = loadManager.loadSignal(); // returns ECGSignal
            includedViewController.runManager(ecgSignal, 3);
            System.out.println("Name: " + loadManager.loadPatientData().getName());
            System.out.println("Surname: " + loadManager.loadPatientData().getSurname());
        } catch (IOException e) {
            DialogPresenter.showInfoDialog("Open file", null, "To see ECG signal you need to choose path to right folder");
        }
    }

    @FXML
    private void save() {
        System.out.println("save");
        try {
            imageRecorder.save(null, includedView.getCenter());
        } catch (IOException e) {
            DialogPresenter.showInfoDialog("Save file", null, "Type file name and click save");
        }

    }

    @FXML
    private void print() {

        ChoiceConfiguration configuration = DialogPresenter.showChoiceDialog(DialogPresenter.ConfigurationTitle.PRINT);
        System.out.println("Chart " + configuration.isChartChoosed()
                + " exData: " + configuration.isExDataChoosed()
                + " params: " + configuration.isParamsChoosed());
        System.out.println("print");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewManager = new ViewManager();
        folderChooseManager = new FolderChooser();
        imageRecorder = new ImageRecorder();
    }
}
