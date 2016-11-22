package pl.dmcs.mcypel.bachelors_degree.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pl.dmcs.mcypel.bachelors_degree.application.model.manager.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matson on 19.11.2016.
 */
public class Welcome implements Initializable {

    private static final String MAIN_FXML_PATH = "../../view/main/main.fxml";

    private ViewManager viewManager;
    @FXML
    private Button startBtn, aboutBtn;

    @FXML
    private void onStartBtnClicked(){
        viewManager.changeView(startBtn, MAIN_FXML_PATH);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewManager = new ViewManager();
    }
}
