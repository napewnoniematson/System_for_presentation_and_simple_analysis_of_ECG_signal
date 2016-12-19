package pl.dmcs.mcypel.bachelors_degree.application.model;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Optional;

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

    public static ChoiceConfiguration showChoiceDialog(ConfigurationTitle title) {
        Dialog<ChoiceConfiguration> dialog = new Dialog();
        VBox vBox = new VBox();

        ButtonType okButton = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        CheckBox chartCheckBox = new CheckBox("Chart");
        CheckBox exDataCheckBox = new CheckBox("Examination data");
        CheckBox paramCheckBox = new CheckBox("Parameters");

        vBox.getChildren().add(chartCheckBox);
        vBox.getChildren().add(exDataCheckBox);
        vBox.getChildren().add(paramCheckBox);

        dialog.setTitle(title.toString() + " CONFIGURATION");
        dialog.setHeaderText("Choose configuration for " + title.toString().toLowerCase());

        dialog.getDialogPane().setContent(vBox);
        dialog.getDialogPane().getButtonTypes().add(okButton);
        dialog.getDialogPane().getButtonTypes().add(cancelButton);

        dialog.setResultConverter(buttonType -> {
            System.out.println(buttonType.toString());
            if (buttonType.getButtonData() == ButtonBar.ButtonData.OK_DONE )
                return new ChoiceConfiguration(
                        chartCheckBox.isSelected(),
                        exDataCheckBox.isSelected(),
                        paramCheckBox.isSelected()
                );
            else
                return null;
        });

        Optional<ChoiceConfiguration> result = dialog.showAndWait();
        if (result.isPresent())
            return result.get();

        return null;
    }

    public enum ConfigurationTitle {
        SAVE, PRINT
    }
}
