package pl.dmcs.mcypel.bachelors_degree.application.utils.print;

import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.stage.Window;
import pl.dmcs.mcypel.bachelors_degree.application.utils.layout.DialogPresenter;
import pl.dmcs.mcypel.bachelors_degree.application.utils.print.manager.PageSettingsManager;
import pl.dmcs.mcypel.bachelors_degree.application.utils.print.manager.PrintSettingsManager;

/**
 * Created by Matson on 08.12.2016.
 */
public class DataPrinter implements PageSettingsManager, PrintSettingsManager {

    private Printer printer; //potrzebne w ogole?
    private PrinterJob job; //create job gdzies

    public DataPrinter(){
        printer = Printer.getDefaultPrinter();
        job = PrinterJob.createPrinterJob();
    }

    public DataPrinter(Printer printer){
        this.printer = printer;
        job = PrinterJob.createPrinterJob();
    }

    @Override
    public void preparePage(Window window) {
        job.showPageSetupDialog(window);
    }

    @Override
    public void preparePrint(Window window) {
        job.showPrintDialog(window);
    }

    public void print(Window window, Node node) {
        boolean isDone = false;
        job = PrinterJob.createPrinterJob();
        if (job != null) {
            preparePage(window);
            preparePrint(window);
            isDone = job.printPage(node);
            if (isDone) {
                job.endJob();
                DialogPresenter.showInfoDialog("Print", "Printing done");
            }
        }
    }


}
