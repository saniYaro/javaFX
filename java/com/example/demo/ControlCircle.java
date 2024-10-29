package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ControlCircle extends Application {
    private CirclePane circlepane = new CirclePane();
    @Override
    public void start(Stage stage) {
        HBox hBox = new HBox();
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);
        btEnlarge.setOnAction(new EnlargeHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlepane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        stage.setScene(scene);
        stage.show();
    }
    class EnlargeHandler
        implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlepane.enlarge();
        }

    }
    static class CirclePane extends StackPane {
        private Circle circle = new Circle(50);
        public CirclePane() {
            getChildren().add(circle);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.WHITE);
        }
        public void enlarge() {
            circle.setRadius(circle.getRadius() + 2);
        }
        public void shrink() {
            circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2: circle.getRadius());
        }

    }

}
