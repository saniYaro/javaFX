package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ShowHBoxVBox extends Application {
@Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        HBox hBox = new HBox(15);
        hBox.setStyle("-fx-background-color: gold");
        hBox.getChildren().add(new Button("Cyber Security"));
        hBox.getChildren().add(new Button("CEWIT"));
        ImageView imageView = new ImageView(new Image("p.jpg"));
        hBox.getChildren().add(imageView);
        pane.setTop(hBox);
        VBox vBox = new VBox(15);
        vBox.getChildren().add(new Label("Courses"));
        Label[] courses = {new Label("CSE114"), new Label("CSE214"), new Label("CSE219"), new Label("CSE308")};

        for (Label course: courses) {
            vBox.getChildren().add(course);
        }
        pane.setLeft(vBox);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
public static void main(String[] args) {
    launch(args);
    }

}
