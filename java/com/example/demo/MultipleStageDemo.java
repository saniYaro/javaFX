package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class MultipleStageDemo extends Application {
    @Override
    public void start(Stage stage){

        Scene scene = new Scene(new Button("OK"), 200, 250);
        stage.setTitle("sYaro");
        stage.setScene(scene);
        stage.show();

        stage = new Stage();
        stage.setTitle("Second Stage");
        stage.setScene(new Scene(new Button("New Stage"),  100, 100));
        stage.show();
    }


public static void main(String[] args){
        launch(args);
        }
}