package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BounceBallControl extends Application {
    @Override
    public void start(Stage stage) {
        BallPane ballPane = new BallPane();

        ballPane.setOnMousePressed(_ -> ballPane.pause());
        ballPane.setOnMouseReleased(_ -> ballPane.play());

        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            } else if (e.getCode() == KeyCode.DOWN) {
                ballPane.decreaseSpeed();
            }
        });
        Scene scene = new Scene(ballPane, 250, 150);
        stage.setTitle("sYaro");
        stage.setScene(scene);
        stage.show();

        ballPane.requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
