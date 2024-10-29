package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class KeyEventDemo extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Text text = new Text(20, 20, "A");
        text.setFocusTraversable(true);
        pane.getChildren().add(text);

        text.setOnKeyPressed(e ->{
            switch (e.getCode()) {
                case DOWN: text.setY(text.getY() + 10); break;
                case UP: text.setY(text.getY() - 10); break;
                case LEFT: text.setX(text.getX() - 10); break;
                case RIGHT: text.setX(text.getX() + 10); break;
                default:
                    if (Character.isLetterOrDigit(e.getText().charAt(0)))
                        text.setText(e.getText());

            }

        });

        Scene scene = new Scene(pane, 200, 200);
        stage.setTitle("KeyEventDemo");
        stage.setScene(scene);
        stage.show();
    }
public static void main(String[] args) {
        launch(args);
        }

}
