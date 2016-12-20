package pl.dmcs.mcypel.bachelors_degree.application.model;

/**
 * Created by Matson on 19.12.2016.
 */
public class ChoiceConfiguration {

    private boolean isChartSelected;
    private boolean isExDataSelected;
    private boolean isParamsSelected;

    public ChoiceConfiguration(boolean isChartSelected, boolean isExDataSelected, boolean isParamsSelected) {
        this.isChartSelected = isChartSelected;
        this.isExDataSelected = isExDataSelected;
        this.isParamsSelected = isParamsSelected;
    }

    public boolean isChartSelected() {
        return isChartSelected;
    }

    public boolean isExDataSelected() {
        return isExDataSelected;
    }

    public boolean isParamsSelected() {
        return isParamsSelected;
    }
}
