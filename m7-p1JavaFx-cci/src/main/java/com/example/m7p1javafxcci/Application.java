package com.example.m7p1javafxcci;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("m7-layout-p1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 617, 400);
        stage.getIcons().add(new Image("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSvGiP1FAo9XQgvVqC7B7nHw1YLHXAKg3TQcSNDmycsNLCvB11m"));        stage.setScene(scene);
        stage.setTitle("Paint geometric figure!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}