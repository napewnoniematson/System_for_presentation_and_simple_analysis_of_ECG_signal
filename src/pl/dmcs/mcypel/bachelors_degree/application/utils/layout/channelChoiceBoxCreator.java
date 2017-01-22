package pl.dmcs.mcypel.bachelors_degree.application.utils.layout;

import javafx.beans.property.IntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matson on 11.01.2017.
 */
public final class ChannelChoiceBoxCreator {

    public static List<CheckBox> createCheckBoxMenu(int channels) {
        List<CheckBox>  menu = new ArrayList<>();
        for (int i = 0; i < channels; ++i) {
            CheckBox checkBox = new CheckBox("Channel: " + (i+1));
            checkBox.selectedProperty().setValue(true);
            checkBox.selectedProperty().addListener(changeListener ->{

            });
            menu.add(checkBox);
        }
        return menu;
    }

    public static HBox createChannelChooseMenu(IntegerProperty channel, int channels) {
        HBox toggleBox = new HBox();
        toggleBox.setSpacing(3);
        ToggleGroup group = new ToggleGroup();

        for (int i = 0; i < channels; ++i) {
            ToggleButton btn = new ToggleButton("Channel " + (i+1));
            btn.selectedProperty().addListener(changeListener ->{
                channel.setValue(Integer.valueOf(btn.getText().substring(8)) - 1);
            });
            btn.setToggleGroup(group);
            toggleBox.getChildren().add(btn);
        }
        return toggleBox;
    }





}
