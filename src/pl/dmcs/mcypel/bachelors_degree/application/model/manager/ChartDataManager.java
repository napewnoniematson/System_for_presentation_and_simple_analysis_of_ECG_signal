package pl.dmcs.mcypel.bachelors_degree.application.model.manager;

import javafx.scene.chart.XYChart;
import pl.dmcs.mcypel.bachelors_degree.application.model.signal.ECGSignal;

/**
 * Created by Matson on 20.11.2016.
 */
public class ChartDataManager {
// TODO: 30.11.2016 buffory danych przed i po

    private ECGSignal ecgSignal;
    private int lowerSample = 0;
    private int upperSample = 0;
    private int difference = 300; //jakies ify gdyby mialo wyjsc za zakres
    private XYChart.Series previousSeries, currentSeries, nextSeries;

    public ChartDataManager() {
    }

    // TODO: 30.11.2016 ify dla series

    /***************************generatedata***************************/

    public XYChart.Series generateSeries(){
        previousSeries = preparePreviousSeries();
        currentSeries = prepareCurrentSeries();
        nextSeries = prepareNextSeries();
        return currentSeries;
    }

    public XYChart.Series generateSeries(int lowerSample, int upperSample){
        setSamples(lowerSample, upperSample);
        return generateSeries();
    }

    private void setSamples(int lowerSample, int upperSample){
        this.lowerSample = lowerSample;
        this.upperSample = upperSample;
        this.difference = upperSample - lowerSample;
    }


    private XYChart.Series preparePreviousSeries(){
        int tempLowerSample = lowerSample - difference;
        int tempUpperSample = lowerSample;
        return prepareChartSeries(tempLowerSample, tempUpperSample, 0);
    }

    private XYChart.Series prepareCurrentSeries(){
        return prepareChartSeries(lowerSample, upperSample, 0);
    }

    private XYChart.Series prepareNextSeries(){
        int tempLowerSample = upperSample;
        int tempUpperSample = upperSample + difference;
        return prepareChartSeries(tempLowerSample, tempUpperSample, 0);
    }

    private XYChart.Series prepareChartSeries(int lowerSample, int upperSample, int channel) {
        // TODO: 27.11.2016 dodaja sie kolejne serie zamiast nadpisywac, upper/lowerbound
        XYChart.Series series = new XYChart.Series();
        series.setName("Channel " + channel);
        for (int i = lowerSample; i < upperSample; ++i) {
            series.getData().add(new XYChart.Data(i, ecgSignal.getChannel(channel)[i]));
        }
        return series;
    }
    /***************************left button***************************/
    public XYChart.Series previous(){
        int tempLowerSample = lowerSample - difference;
        int tempUpperSample = lowerSample;
        setSamples(tempLowerSample, tempUpperSample);
        nextSeries = currentSeries;
        currentSeries = previousSeries;
        previousSeries = preparePreviousSeries();
        return currentSeries;
    }
    /***************************right button***************************/
    public XYChart.Series next() {
        int tempLowerSample = upperSample;
        int tempUpperSample = upperSample + difference;
        setSamples(tempLowerSample, tempUpperSample);
        previousSeries = currentSeries;
        currentSeries = nextSeries;
        nextSeries = prepareNextSeries();
        return currentSeries;
//        setsamples + prepare ?


    }
    /***************************zooming method***************************/



        /*public void generateChart(LineChart lineChart, ECGSignal ecgSignal){
        ObservableList<XYChart.Series> chartData;
        XYChart.Series<Integer, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < 10; ++i) {
            series.getData().add(new XYChart.Data(i, i));
        }
        chartData = FXCollections.observableArrayList(Collections.singleton(series));
        lineChart.setData(chartData);
//        System.out.println("Wykreślony Chart");
    }*/
}
