package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class ExternalCSSFile extends Application {
    @Override

    public void start (Stage stage) {
        try {
           BorderPane root = new BorderPane();
           Scene scene = new Scene(root, 400, 400);
           scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
           stage.setScene(scene);
           stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public static void main(String[] args) {
        launch(args);
        }
}
