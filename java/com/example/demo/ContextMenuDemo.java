package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

public class ContextMenuDemo extends Application {
    @Override

    public void start(Stage stage) {

        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItemNew = new MenuItem("New",
                new ImageView("new.gif"));
        MenuItem menuItemOpen = new MenuItem("Open",
                new ImageView("open.gif"));
        MenuItem menuItemPrint = new MenuItem("Print",
                new ImageView("print.gif"));
        MenuItem menuItemExit = new MenuItem("Exit");
        contextMenu.getItems().addAll(menuItemNew, menuItemOpen,

                menuItemPrint, menuItemExit);
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 250);
        stage.setTitle("sYaro");
        stage.setScene(scene);
        stage.show();

        pane.setOnMousePressed(
                e -> contextMenu.show(pane, e.getScreenX(), e.getScreenY()));
        menuItemNew.setOnAction(e -> System.out.println("New"));
        menuItemOpen.setOnAction(e -> System.out.println("Open"));
        menuItemPrint.setOnAction(e -> System.out.println("Print"));
        menuItemExit.setOnAction(e -> System.exit(0));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
