package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

import java.util.List;

/**
 * Created by Matson on 20.11.2016.
 */
public class PrintManager {

    // TODO: 24.11.2016 drukowanie w nowym wątku

    private Printer printer; //potrzebne w ogole?
    private PrinterJob job; //create job gdzies


    public PrintManager (){
        printer = Printer.getDefaultPrinter();
    }

    public PrintManager (Printer printer){
        this.printer = printer;
    }

    //w zaleznosci od checkboxow beda rozne vboxy?
    public Node preparePrintingNode (List<Node> nodes) {
        //Vbox albo jakis panel
        VBox box = new VBox();
        for (Node node : nodes) {
            box.getChildren().add(node);
        }
        return box;
    }

    private void preparePage(Window window) {
        job.showPageSetupDialog(window); //zwraca boolean <- true gdy ktos zatwierdzi zmiany false gdy cancel albo nie wyskoczy okienko
    }


    private void preparePrint(Window window) {
        job.showPrintDialog(window); // to samo co w preparePage
    }

    //cancel print?
    //resizing node ?
    private void print(Window window, Node node) {
        //ify po showprint showpage i wtedy w zaleznosci od nich zmieniac printowanie czy w/e?
        boolean isDone = false;
        if (job != null) {
            preparePage(window);
            preparePrint(window);
            isDone = job.printPage(node);
            if (isDone)
                job.endJob();
            //else... jakies message z wykorzystaniem propertasow?

        }
    }
}
