package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.collections.FXCollections;

public class ListViewDemo extends Application {

    private String[] flagTitles = {"United States of America", "Canada", "China",
            "Denmark", "France", "Germany", "India", "Nigeria"};

    private ImageView[] ImageViews = {
            new ImageView("us.gif"),
            new ImageView("ca.gif"),
            new ImageView("china.gif"),
            new ImageView("denmark.gif"),
            new ImageView("fr.gif"),
            new ImageView("germany.gif"),
            new ImageView("india.gif"),
            new ImageView("ng.gif")
    };
    @Override
    public void start(Stage stage) {
        ListView<String> lv = new ListView<>(FXCollections
                .observableArrayList(flagTitles));

        lv.setPrefSize(400, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(imagePane);
        lv.getSelectionModel().selectedItemProperty().addListener(
                ov -> {
                    imagePane.getChildren().clear();
                    for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
                        imagePane.getChildren().add(ImageViews[i]);
                    }
                });

        Scene scene = new Scene(pane, 450, 170);
        stage.setTitle("ListViewDemo");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
