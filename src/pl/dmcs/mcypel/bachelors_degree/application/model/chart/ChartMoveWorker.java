package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ChartMoveManager;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 08.12.2016.
 */
public class ChartMoveWorker implements ChartMoveManager {

    private int lowerBound = 0;
    private int upperBound = 0;
    private int diff = 0;
    private ECGSignal ecgSignal = null;
    private XYChart.Series previousSeries = null;
    private XYChart.Series currentSeries = null;
    private XYChart.Series nextSeries = null;

    // TODO: 12.12.2016 moze trzeba tu umiescic chartseriesprovider bo jak sie zmieni generowanie to takze tu sie powinno zmienic
    public ChartMoveWorker(ECGSignal ecgSignal, int lowerBound, int upperBound, XYChart.Series currentSeries) {
        setBounds(lowerBound, upperBound);
        this.ecgSignal = ecgSignal;
        this.currentSeries = currentSeries;
        previousSeries = generatePreviousSeries();
        nextSeries = generateNextSeries();
    }

    @Override
    public void setBounds(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        diff = this.upperBound - this.lowerBound;
    }

    @Override
    public XYChart.Series previous() {
        int tempLowerBound = lowerBound - diff;
        int tempUppertBound = lowerBound;
        setBounds(tempLowerBound, tempUppertBound);
        nextSeries = currentSeries;
        currentSeries = previousSeries;
        previousSeries = generatePreviousSeries();
        return currentSeries;
    }

    @Override
    public XYChart.Series next() {
        int tempLowerBound = upperBound;
        int tempUppertBound = upperBound + diff;
        setBounds(tempLowerBound, tempUppertBound);
        previousSeries = currentSeries;
        currentSeries = nextSeries;
        nextSeries = generateNextSeries();
        return currentSeries;
    }

    private XYChart.Series generatePreviousSeries() {
        int tempLowerBound = lowerBound - diff;
        int tempUpperBound = lowerBound;
        return SeriesGenerator.generate(ecgSignal, tempLowerBound, tempUpperBound,0);
    }

    private XYChart.Series generateNextSeries() {
        int tempLowerBound = upperBound;
        int tempUpperBound = upperBound + diff;
        return SeriesGenerator.generate(ecgSignal, tempLowerBound, tempUpperBound,0);
    }
}
