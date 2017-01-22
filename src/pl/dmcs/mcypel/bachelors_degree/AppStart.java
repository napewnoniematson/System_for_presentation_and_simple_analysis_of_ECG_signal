package pl.dmcs.mcypel.bachelors_degree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class AppStart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
/*        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setResources(ResourceBundle.getBundle("pl/dmcs/mcypel/bachelors_degree/resources/lang_en.properties",
                Locale.ENGLISH));*/

        Parent root = FXMLLoader.load(getClass().getResource("application/view/main/main.fxml"));
        primaryStage.setTitle("System for presentation and simple analysis of ECG signal");
        primaryStage.getIcons().add(new Image("pl/dmcs/mcypel/bachelors_degree/application/images/logo.png"));
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
