package com.example.demo;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TimeLineDemo extends Application {
    @Override
    public void start(Stage stage) {

        StackPane pane = new StackPane();
        Text text = new Text(20, 50, "Programming if fun");
        text.setFill(Color.RED);
        pane.getChildren().add(text);

        EventHandler<ActionEvent> eH = _ -> {
            if (text.getText().length() != 0) {
                text.setText("");
            } else {
                text.setText("Programming is fun");
            }
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), eH));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        text.setOnMouseClicked(e -> {
            if (animation.getStatus() ==
                    Animation.Status.PAUSED) {
                animation.play();
            } else {
                animation.pause();
            }
        });
        Scene scene = new Scene(pane, 250, 50);
        stage.setTitle("sYaro");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}