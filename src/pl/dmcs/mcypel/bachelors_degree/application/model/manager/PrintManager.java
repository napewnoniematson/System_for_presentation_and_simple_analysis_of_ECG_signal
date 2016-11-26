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

    private Printer printer;
    private PrinterJob job;


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
//
//    private boolean preparePageAttributes(PrinterJob job){
//        job = PrinterJob.createPrinterJob();
//    }

    private void preparePageForPrint(Window window){

        if (job != null){
            job.showPageSetupDialog(window); //zwraca boolean <- true gdy ktos zatwierdzi zmiany false gdy cancel albo nie wyskoczy okienko
        }

    }


    private void preparePrint(Window window) {

        if (job != null){
            job.showPrintDialog(window); // to samo co w preparePageForPrint
        }
    }

    //cancel print?
    //resizing node ?
    private void print(Node node) {

        //ify po showprint showpage i wtedy w zaleznosci od nich zmieniac printowanie czy w/e?
        boolean isDone = false;

        if (job != null) {
            isDone = job.printPage(node);

            if (isDone)
                job.endJob();
            //else... jakies message z wykorzystaniem propertasow?

        }


    }


}
