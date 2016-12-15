package pl.dmcs.mcypel.bachelors_degree.application.model.chart;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.chart.NumberAxis;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pl.dmcs.mcypel.bachelors_degree.application.model.chart.manager.ZoomManager;

/**
 * Created by Matson on 08.12.2016.
 */
public class ZoomWorker implements ZoomManager{

//    private LineChart lineChart;

//
//    public ZoomManager (LineChart lineChart, Rectangle rectangle) {
//        this.lineChart = lineChart;
//        this.rectangle = rectangle;
//    }

    private final ObjectProperty<Point2D> mouseCursorPoint = new SimpleObjectProperty<>();
    private Rectangle rectangle;
    private NumberAxis xAxis, yAxis;
    private Point2D areaLeftTop, areaRightBottom;
    private Point2D xAxisToScene, yAxisToScene;
    private double xOffset, yOffset, xAxisScale, yAxisScale;

    //onZoomButton
    private void zoom() {
        areaLeftTop = new Point2D(rectangle.getX(), rectangle.getY());
        areaRightBottom = new Point2D(rectangle.getX() + rectangle.getWidth(), rectangle.getY() + rectangle.getHeight());
        xAxisToScene = xAxis.localToScene(0, 0);
        yAxisToScene = yAxis.localToScene(0, 0);
        xOffset = areaLeftTop.getX() - yAxisToScene.getX();
        yOffset = areaRightBottom.getY() - xAxisToScene.getX();
        xAxisScale = xAxis.getScale();
        yAxisScale = yAxis.getScale();
        xAxis.setLowerBound(xAxis.getLowerBound() + xOffset / xAxisScale);
        xAxis.setUpperBound(xAxis.getLowerBound() + rectangle.getWidth() / xAxisScale);
        yAxis.setLowerBound(yAxis.getLowerBound() + yOffset / yAxisScale);
        yAxis.setUpperBound(yAxis.getLowerBound() - rectangle.getHeight() / yAxisScale);
        rectangle.setWidth(0);
        rectangle.setHeight(0);
//        System.out.println(yAxis.getLowerBound() + " " + yAxis.getUpperBound());
    }


    //onResetButton?
    private void cancelZoom() {
        xAxis.setLowerBound(100000);
        xAxis.setUpperBound(100100);
        yAxis.setLowerBound(100);
        yAxis.setUpperBound(200);
        rectangle.setWidth(0);
        rectangle.setHeight(0);
    }

    //setOnMousePressed
    private void setStartPointPressed(MouseEvent event) {
        mouseCursorPoint.set(new Point2D(event.getX(), event.getY()));
        rectangle.setWidth(0);
        rectangle.setHeight(0);
    }

    //setOnMouseDragged
    private void selectArea(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        rectangle.setX(Math.min(x, mouseCursorPoint.get().getX()));
        rectangle.setY(Math.min(y, mouseCursorPoint.get().getY()));
        rectangle.setWidth(Math.abs(x - mouseCursorPoint.get().getX()));
        rectangle.setHeight(Math.abs(y - mouseCursorPoint.get().getY()));
    }
}
