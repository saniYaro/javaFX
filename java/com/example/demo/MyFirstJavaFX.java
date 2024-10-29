package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class MyFirstJavaFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button btOK = new Button("OK");
        Scene scene = new Scene(btOK, 100, 150);
        stage.setTitle("sYaro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}