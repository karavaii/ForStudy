package com.cgvsu.rasterizationfxapp;

import com.cgvsu.MyObjAndMeth.Point;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        //Rasterization.drawRectangle(canvas.getGraphicsContext2D(), 200, 300, 200, 100, Color.CHOCOLATE);
        //Rasterization.drawRectangle(canvas.getGraphicsContext2D(), 250, 250, 50, 200, Color.AQUA);

        Point p1 = new Point(150, 250, 0), p2 = new Point(250, 350, 0);

        //Rasterization.drawCircle(canvas.getGraphicsContext2D(), 250, 250, 100, Color.ROSYBROWN);
        Rasterization.drawPieceOfPie(canvas.getGraphicsContext2D(), 250, 250, 100, p1, p2, Color.GREEN);
    }

}