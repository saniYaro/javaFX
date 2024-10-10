package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class ShowFlowPane extends Application {
    @Override
    public void start(Stage stage){
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(11, 12, 13, 14));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
        TextField tfMi = new TextField();
        tfMi.setPrefColumnCount(1);
        pane.getChildren().addAll(tfMi, new Label("Last Name;"), new TextField());

        Scene scene = new Scene(pane, 210, 150);
        stage.setTitle("ShowFlowPane");
        stage.setScene(scene);
        stage.show();
    }
public static void main(String[] args){
        launch(args);
        }
}