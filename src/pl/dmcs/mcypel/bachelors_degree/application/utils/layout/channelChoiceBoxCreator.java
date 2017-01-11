package pl.dmcs.mcypel.bachelors_degree.application.utils.layout;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

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




}
