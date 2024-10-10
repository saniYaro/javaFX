package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class LambdaHandlerDemo extends Application {
    @Override
    public void start(Stage stage) {
       HBox hBox = new HBox();
       hBox.setSpacing(10);
       hBox.setAlignment(Pos.CENTER);
       Button btNew = new Button("New");
       Button btOpen = new Button("Open");
       Button btSave = new Button("Save");
       Button btPrint = new Button("Print");
       hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);

       btNew.setOnAction(e -> {System.out.println("Process New");});
       btOpen.setOnAction(e -> {System.out.println("Process Open");});
       btSave.setOnAction(e -> {System.out.println("Process Save");});
       btPrint.setOnAction(e -> {System.out.println("Process Print");});

       Scene scene = new Scene(hBox, 200, 50);
       stage.setTitle("sYaro");
       stage.setScene(scene);
       stage.show();
    }
public static void main(String[] args) {
        launch(args);
        }


}
