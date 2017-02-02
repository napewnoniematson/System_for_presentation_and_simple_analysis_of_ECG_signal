package pl.dmcs.mcypel.bachelors_degree.application.utils.layout;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pl.dmcs.mcypel.bachelors_degree.application.model.ChoiceConfiguration;

import java.net.URL;
import java.util.Optional;

/**
 * Created by Matson on 15.12.2016.
 */
public final class DialogPresenter {

    public static void showInfoDialog(String title, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("pl/dmcs/mcypel/bachelors_degree/application/images/logo.png"));
        alert.getDialogPane().getStylesheets().addAll("pl/dmcs/mcypel/bachelors_degree/application/styles/chartManagementStyle.css",
                "pl/dmcs/mcypel/bachelors_degree/application/styles/buttonsStyle.css");
        alert.getDialogPane().setBackground(new Background(new BackgroundImage(new Image("pl/dmcs/mcypel/bachelors_degree/application/images/background_black_red.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        alert.showAndWait();
    }

    public static ChoiceConfiguration showChoiceDialog(ConfigurationTitle title) {
        Dialog<ChoiceConfiguration> dialog = new Dialog();
        VBox vBox = new VBox();

        BooleanProperty isChartButtonSelectedProperty = new SimpleBooleanProperty();
        BooleanProperty isPeaksButtonSelectedProperty = new SimpleBooleanProperty();
        BooleanProperty isExDataButtonSelectedProperty = new SimpleBooleanProperty();

        ((Stage)dialog.getDialogPane().getScene().getWindow()).getIcons().add(new Image("pl/dmcs/mcypel/bachelors_degree/application/images/logo.png"));
        dialog.getDialogPane().setBackground(new Background(new BackgroundImage(new Image("pl/dmcs/mcypel/bachelors_degree/application/images/background_black_red.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        dialog.getDialogPane().getStylesheets().add("pl/dmcs/mcypel/bachelors_degree/application/styles/buttonsStyle.css");
        ButtonType okButton = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        ToggleGroup group = new ToggleGroup();
        ToggleButton chartCheckBox = new ToggleButton("Chart");
        chartCheckBox.setToggleGroup(group);
        chartCheckBox.setMaxSize(1.7976931348623157E308, 1.7976931348623157E308);
        setListener(chartCheckBox, isChartButtonSelectedProperty);
        vBox.getChildren().add(chartCheckBox);

        ToggleButton peaksCheckBox = new ToggleButton("Peaks");
        peaksCheckBox.setToggleGroup(group);
        peaksCheckBox.setMaxSize(1.7976931348623157E308, 1.7976931348623157E308);
        setListener(peaksCheckBox, isPeaksButtonSelectedProperty);
        vBox.getChildren().add(peaksCheckBox);

        ToggleButton exDataCheckBox = new ToggleButton("Examination data");
        exDataCheckBox.setToggleGroup(group);
        exDataCheckBox.setMaxSize(1.7976931348623157E308, 1.7976931348623157E308);
        setListener(exDataCheckBox, isExDataButtonSelectedProperty);
        vBox.getChildren().add(exDataCheckBox);

        dialog.setTitle(title.toString());
        dialog.getDialogPane().setContent(vBox);
        dialog.getDialogPane().getButtonTypes().add(okButton);
        dialog.getDialogPane().getButtonTypes().add(cancelButton);

        dialog.setResultConverter(buttonType -> {
            System.out.println(buttonType.toString());
            if (buttonType.getButtonData() == ButtonBar.ButtonData.OK_DONE )
                    if (isChartButtonSelectedProperty.get() || isPeaksButtonSelectedProperty.get() || isExDataButtonSelectedProperty.get())
                        return new ChoiceConfiguration(
                                isChartButtonSelectedProperty.get(),
                                isPeaksButtonSelectedProperty.get(),
                                isExDataButtonSelectedProperty.get()
                );
                    else
                        return null;
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

    private static void setListener(ToggleButton button, BooleanProperty isSelectedProperty) {
        button.selectedProperty().addListener(listener ->{
                isSelectedProperty.bind(button.selectedProperty());
        });
    }


}
