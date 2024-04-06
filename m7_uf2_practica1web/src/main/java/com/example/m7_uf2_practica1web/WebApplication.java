package com.example.m7_uf2_practica1web;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class WebApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WebView webView = new WebView();

        webView.getEngine().load("https://www.goodreads.com/"); // Cambia la URL según lo que desees mostrar

        BorderPane root = new BorderPane();
        root.setCenter(webView);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Mostrar Sitio Web");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}