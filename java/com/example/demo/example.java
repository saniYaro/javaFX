package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class example extends Application {
    @Override
    public void start(Stage stage) {
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("OK"));
        Scene scene = new Scene(pane, 200, 50);
        stage.setTitle("sYaro");
        stage.setScene(scene);
        stage.show();
    }

public static void main(String[] args){
        launch(args);
                    }
}
