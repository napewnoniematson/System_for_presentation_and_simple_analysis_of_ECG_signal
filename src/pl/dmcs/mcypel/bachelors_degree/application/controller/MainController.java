package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import pl.dmcs.mcypel.bachelors_degree.application.model.ChoiceConfiguration;
import pl.dmcs.mcypel.bachelors_degree.application.utils.layout.DialogPresenter;
import pl.dmcs.mcypel.bachelors_degree.application.model.examination.ExaminationData;
import pl.dmcs.mcypel.bachelors_degree.application.utils.folder.FolderChooser;
import pl.dmcs.mcypel.bachelors_degree.application.utils.load.DataLoader;
import pl.dmcs.mcypel.bachelors_degree.application.utils.folder.manager.FolderChooseManager;
import pl.dmcs.mcypel.bachelors_degree.application.utils.load.manager.DataLoadManager;
import pl.dmcs.mcypel.bachelors_degree.application.utils.print.DataPrinter;
import pl.dmcs.mcypel.bachelors_degree.application.utils.save.ImageRecorder;
import pl.dmcs.mcypel.bachelors_degree.application.utils.save.manager.ImageSaveManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 19.11.2016.
 */
public class MainController implements Initializable{

    private static final String CHART_PRESENTATION_FXML_PATH = "../../view/included/chart_presentation.fxml";
    private static final String PATIENT_DATA_FXML_PATH = "../../view/included/examination_data.fxml";
    private static final String PARAMETERS_FXML_PATH = "../../view/included/parameters.fxml";

    private DataLoadManager loadManager;
    private ImageSaveManager imageRecorder;
    private DataPrinter dataPrinter;
    private FolderChooseManager folderChooseManager;

    @FXML
    private ChartPresentationController includedPresentationController;
    @FXML
    private ChartManagementController includedViewController;
    @FXML
    private ExaminationDataController includedExaminationDataViewController;
    private ECGSignal ecgSignal;
    private ExaminationData examinationData;

    @FXML
    private void load(ActionEvent event) {
        try {
            folderChooseManager.chooseOpenFolder(null);
            loadManager = new DataLoader(folderChooseManager);
            ecgSignal = loadManager.loadSignal(); // returns ECGSignal
            examinationData = loadManager.loadExaminationData();
            includedViewController.runManager(ecgSignal, ecgSignal.getChannelsNumber(), includedPresentationController);
            includedExaminationDataViewController.showDataOnView(folderChooseManager.getFolderName(),
                    ecgSignal.getSamplingFrequency(),examinationData);
        } catch (IOException e) {
            DialogPresenter.showInfoDialog("Open file", "To see ECG signal you need to choose path to right folder");
        }
    }

    @FXML
    private void save() {
        try {
            ChoiceConfiguration configuration = DialogPresenter.showChoiceDialog(DialogPresenter.ConfigurationTitle.SAVE);
            if (configuration != null){
                imageRecorder.save(null, selectNode(configuration));
            }
        } catch (IOException e) {
            DialogPresenter.showInfoDialog("Save file", "Type file name and click save");
        }

    }

    @FXML
    private void print() {
        ChoiceConfiguration configuration = DialogPresenter.showChoiceDialog(DialogPresenter.ConfigurationTitle.PRINT);
        if (configuration != null){
            dataPrinter.print(null, selectNode(configuration));
        }
    }

    private Node selectNode(ChoiceConfiguration configuration) {
        if (configuration.isChartSelected())
            return includedPresentationController.getEcgLineChart();
        if (configuration.isPeaksSelected())
            return includedPresentationController.getEcgLineChartPeaks();
        if (configuration.isExDataSelected())
            return includedExaminationDataViewController.getExaminationPane();
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        folderChooseManager = new FolderChooser();
        imageRecorder = new ImageRecorder();
        dataPrinter = new DataPrinter();
    }
}
