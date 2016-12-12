package pl.dmcs.mcypel.bachelors_degree;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
//        primaryStage.setScene(new Scene(root, 500, 150));
        primaryStage.setScene(new Scene(root, 1000, 700));

        primaryStage.show();

       /* DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(null);
        System.out.println(file.getName());
        file = directoryChooser.showDialog(null);
        System.out.println(file.getParent());*/

    }


    public static void main(String[] args) {
        launch(args);
    }
}
