package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.scene.Node;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Created by Matson on 20.11.2016.
 */
public class PrintManager {

    public PrintManager (){}

    public Node preparePrintingNode (List<Node> nodes) {

        VBox box = new VBox();

        for (Node node : nodes) {
            box.getChildren().add(node);
        }
        return box;
    }





}
