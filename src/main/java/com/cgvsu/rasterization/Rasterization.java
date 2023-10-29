package com.cgvsu.rasterization;

import com.cgvsu.MyObjAndMeth.Methods;
import com.cgvsu.MyObjAndMeth.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Rasterization {

    public static void drawRectangle(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int width, final int height,
            final Color color) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y; row < y + height; ++row)
            for (int col = x; col < x + width; ++col)
                pixelWriter.setColor(col, row, color);
    }

    //метод для рисования окружности
    //проверка нахождения внутри круга: (x - x_center)^2 + (y - y_center)^2 <= radius^2

    //результирующие векторы должны быть сонаправлены
    //т.е. по Oz они должны быть одного знака
    //т е если их друг на друга умножить то они будут со знаком +

    public static void drawCircle(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int radius,
            final Color color) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y - radius; row < y + radius; ++row)
            for (int col = x - radius; col < x + radius; ++col)
                if (Math.pow((row - x), 2) + Math.pow((col - y), 2) <= Math.pow(radius, 2))
                    pixelWriter.setColor(col, row, color);
    }

    public static void drawPieceOfPie(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int radius,
            final Point p1, final Point p2,
            final Color color) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        List<Point> points = new ArrayList<>();
        points.add(0, p1);
        points.add(1, p2);

        for (int row = y - radius; row < y + radius; ++row) {
            for (int col = x - radius; col < x + radius; ++col) {
                points.add(2, new Point(row, col, 0));
                if (Math.pow((row - x), 2) + Math.pow((col - y), 2) <= Math.pow(radius, 2) && Methods.getVectorsOrient(points, new Point(x, y, 0)))
                    pixelWriter.setColor(col, row, color);
                points.remove(2);
            }
        }

    }
}













