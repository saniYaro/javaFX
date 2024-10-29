package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class FlagRisingAnimation extends Application {
    @Override

    public void start(Stage stage) {

        Pane pane = new Pane();
        ImageView imageView = new ImageView("a.jpg");
        pane.getChildren().add(imageView);

        PathTransition pt = new PathTransition(
                Duration.millis(1000),
                new Line(100, 200, 100, 0),
                imageView);
        pt.setCycleCount(5);
        pt.play();

        Scene scene = new Scene(pane, 350, 350);
        stage.setScene(scene);
        stage.show();
    }

public static void main(String[] args) {
        launch(args);
}


}
