package pl.dmcs.mcypel.bachelors_degree.application.model;

/**
 * Created by Matson on 19.12.2016.
 */
public class ChoiceConfiguration {

    private boolean isChartChoosed;
    private boolean isExDataChoosed;
    private boolean isParamsChoosed;

    public ChoiceConfiguration(boolean isChartChoosed, boolean isExDataChoosed, boolean isParamsChoosed) {
        this.isChartChoosed = isChartChoosed;
        this.isExDataChoosed = isExDataChoosed;
        this.isParamsChoosed = isParamsChoosed;
    }

    public boolean isChartChoosed() {
        return isChartChoosed;
    }

    public boolean isExDataChoosed() {
        return isExDataChoosed;
    }

    public boolean isParamsChoosed() {
        return isParamsChoosed;
    }
}
