package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class ShowCircleCentered extends Application {
    @Override
    public void start(Stage stage){
      Pane pane = new Pane();
      Circle circle = new Circle();

      circle.centerXProperty().bind(pane.widthProperty().divide(2));
      circle.centerYProperty().bind(pane.heightProperty().divide(2));
      circle.setRadius(50);
      circle.setStroke(Color.BLACK);
      circle.setFill(Color.WHITE);
      pane.getChildren().add(circle);

      Scene scene = new Scene(pane, 200, 200);
      stage.setTitle("ShowCircleCentered");
      stage.setScene(scene);
      stage.show();
    }
public static void main(String[] args){
        launch(args);
        }
}