package com.example.demo;


import javafx.scene.Parent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.beans.binding.Bindings;
import javafx.scene.text.Font;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
    private double w = 250, h = 250;

    public ClockPane(){
        setCurrentTime();
        widthProperty().addListener((obs,oldVal, newVal)-> paintClock());
        heightProperty().addListener((obs, oldVal, newVal)-> paintClock());
    }
    public ClockPane(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        widthProperty().addListener((obs, oldVal, newVal)-> paintClock());
        heightProperty().addListener((obs, oldVal, newVal)-> paintClock());
        paintClock();
    }
    public int getHour(){
        return hour;
    }
    public void setHour(int hour){
        this.hour = hour;
        paintClock();
    }
    public int getMinute(){
        return minute;
    }
    public void setMinute(int minute){
        this.minute = minute;
        paintClock();
    }
    public int getSecond(){
        return second;
    }
    public void setSecond(int second){
        this.second = second;
        paintClock();
    }
    public double getW(){
        return w;
    }
    public void setW(double w){
        this.w = w;
        paintClock();
    }
    public double getH(){
        return h;
    }
    public void setH(double h){
        this.h = h;
        paintClock();
    }
    public void setCurrentTime(){
        Calendar calender = new GregorianCalendar();
        this.hour = calender.get(Calendar.HOUR_OF_DAY);
        this.minute = calender.get(Calendar.MINUTE);
        this.second = calender.get(Calendar.SECOND);
        paintClock();
    }
    private void paintClock(){
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle();
        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(heightProperty().divide(2));
        circle.radiusProperty().bind(Bindings.min(widthProperty(), heightProperty()).multiply(0.8).multiply(0.5));
        circle.setFill(Color.SANDYBROWN);
        circle.setStroke(Color.BLACK);

        double maxFontSize = clockRadius * 0.2;
        Font font = new Font(maxFontSize);

        Text t1 = new Text("12");
        t1.fontProperty().bind(Bindings.createObjectBinding(() ->
                new Font(Math.min(maxFontSize, Math.min(getWidth(), getHeight()) * 0.05)), widthProperty(), heightProperty()));
        t1.xProperty().bind(circle.centerXProperty().subtract(5));
        t1.yProperty().bind(circle.centerYProperty().subtract(circle.radiusProperty()).add(12));

        Text t2 = new Text("9");
        t2.fontProperty().bind(Bindings.createObjectBinding(() ->
                new Font(Math.min(maxFontSize, Math.min(getWidth(), getHeight()) * 0.05)), widthProperty(), heightProperty()));

        t2.xProperty().bind(circle.centerXProperty().subtract(circle.radiusProperty()).add(3));
        t2.yProperty().bind(circle.centerYProperty().add(5));

        Text t3 = new Text("3");
        t3.fontProperty().bind(Bindings.createObjectBinding(() ->
                new Font(Math.min(maxFontSize, Math.min(getWidth(), getHeight()) * 0.05)), widthProperty(), heightProperty()));
        t3.xProperty().bind(circle.centerXProperty().add(circle.radiusProperty()).subtract(10));
        t3.yProperty().bind(circle.centerYProperty().add(3));

        Text t4 = new Text("6");

        t4.fontProperty().bind(Bindings.createObjectBinding(() ->
                new Font(Math.min(maxFontSize, Math.min(getWidth(), getHeight()) * 0.05)), widthProperty(), heightProperty()));
        t4.xProperty().bind(circle.centerXProperty().subtract(3));
        t4.yProperty().bind(circle.centerYProperty().add(circle.radiusProperty()).subtract(3));

        double sLength = clockRadius * 0.8;
        Line sLine = new Line();
        sLine.startXProperty().bind(circle.centerXProperty());
        sLine.startYProperty().bind(circle.centerYProperty());

        sLine.endXProperty().bind(circle.centerXProperty().add(circle.radiusProperty().multiply(0.8).multiply(Math.sin(second * (2 * Math.PI / 60)))));
        sLine.endYProperty().bind(circle.centerYProperty().subtract(circle.radiusProperty().multiply(0.8).multiply(Math.cos(second * (2 * Math.PI / 60)))));
        sLine.setStroke(Color.RED);

        double mLength = clockRadius * 0.65;
        Line mLine = new Line();
        mLine.startXProperty().bind(circle.centerXProperty());
        mLine.startYProperty().bind(circle.centerYProperty());

        mLine.endXProperty().bind(circle.centerXProperty().add(circle.radiusProperty().multiply(0.65).multiply(Math.sin(minute * (2 * Math.PI / 60)))));
        mLine.endYProperty().bind(circle.centerYProperty().subtract(circle.radiusProperty().multiply(0.65).multiply(Math.cos(minute * (2 * Math.PI / 60)))));
        mLine.setStroke(Color.PURPLE);

        double hLength = clockRadius * 0.5;
        Line hLine = new Line();
        hLine.startXProperty().bind(circle.centerXProperty());
        hLine.startYProperty().bind(circle.centerYProperty());

        hLine.endXProperty().bind(circle.centerXProperty().add(circle.radiusProperty().multiply(0.5).multiply(Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)))));
        hLine.endYProperty().bind(circle.centerYProperty().subtract(circle.radiusProperty().multiply(0.5).multiply(Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)))));
        hLine.setStroke(Color.BLACK);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
        }

}