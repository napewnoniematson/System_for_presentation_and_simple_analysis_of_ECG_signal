package pl.dmcs.mcypel.bachelors_degree.application.model;

import javafx.scene.control.Alert;

/**
 * Created by Matson on 15.12.2016.
 */
public final class DialogPresenter {

    public static void showInfoDialog(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
