package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.io.IOException;

/**
 * Created by Matson on 20.11.2016.
 */
public class ViewManager {

    private Pane window;
    private Scene scene;
    private Stage stage;

    // TODO: 24.11.2016 zobaczyc rozmiary widokow
    public ViewManager(){

    }

    public void changeView(Button button, String pathToView){
        try {
            window = FXMLLoader.load(getClass().getResource(pathToView));
            scene = new Scene(window, 800, 600);
            stage = (Stage) button.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeIncludedView (Pane pane, String pathToView){
        clearPane(pane);
        addNewViewToPane(pane, pathToView);
    }

    private void clearPane(Pane pane){
        pane.getChildren().clear();
    }

    private void addNewViewToPane(Pane pane, String pathToView){
        try {
            pane.getChildren().add((Node) FXMLLoader.load(getClass().getResource(pathToView)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
