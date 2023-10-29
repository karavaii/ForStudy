package com.cgvsu.rasterizationfxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*7. Реализовать метод (класс) для заполнения сектора окружности.
Добавить возможность интерполяции цвета, например, при удалении от центра круга.*/

/*
1. сделать метод рисования круга (закрашивание)
2. сделать простое закрашивание сектора цветом (проход по всему кругу и проверка точки на принадлежность)
3. сделать интерполяцию
*/
public class RasterizationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RasterizationApplication.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Rasterization App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}