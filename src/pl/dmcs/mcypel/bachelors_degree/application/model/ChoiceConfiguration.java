package pl.dmcs.mcypel.bachelors_degree.application.model;

/**
 * Created by Matson on 19.12.2016.
 */
public class ChoiceConfiguration {

    private boolean isChartSelected;
    private boolean isExDataSelected;
    private boolean isPeaksSelected;

    public ChoiceConfiguration(boolean isChartSelected, boolean isPeaksSelected, boolean isExDataSelected) {
        this.isChartSelected = isChartSelected;
        this.isExDataSelected = isExDataSelected;
        this.isPeaksSelected = isPeaksSelected;
    }

    public boolean isChartSelected() {
        return isChartSelected;
    }

    public boolean isExDataSelected() {
        return isExDataSelected;
    }

    public boolean isPeaksSelected() {
        return isPeaksSelected;
    }
}
