package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.HPos;


public class LoanCalculator extends Application {
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");
    @Override
    public void start(Stage stage) {

       GridPane gridPane = new GridPane();
       gridPane.setHgap(5);
       gridPane.setVgap(5);
       gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
       gridPane.add(tfAnnualInterestRate, 1, 0);
       gridPane.add(new Label("Number of Years:"), 0, 1);
       gridPane.add(tfNumberOfYears, 1, 1);
       gridPane.add(new Label("Number of Years:"), 0, 1);
       gridPane.add(tfNumberOfYears, 1, 1);
       gridPane.add(new Label("Loan Amount:"), 0, 2);
       gridPane.add(tfLoanAmount, 1, 2);
       gridPane.add(new Label("Monthly Payment:"), 0, 3);
       gridPane.add(tfMonthlyPayment, 1, 3);
       gridPane.add(new Label("Total Payment:"), 0, 4);
       gridPane.add(tfTotalPayment, 1, 4);
       gridPane.add(btCalculate, 1, 5);

       btCalculate.setOnAction(e -> calculateLoanPayment());

       Scene scene = new Scene(gridPane, 400, 250);
       stage.setScene(scene);
       stage.show();
    }

private void calculateLoanPayment() {

       double interest = Double.parseDouble(tfAnnualInterestRate.getText());
       int year = Integer.parseInt(tfNumberOfYears.getText());
       double loanAmount = Double.parseDouble(tfLoanAmount.getText());

       Loan loan = new Loan(interest, year, loanAmount);
               tfMonthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
               tfTotalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
       }

public static void main(String[] args) {
        launch(args);
       }

class Loan implements java.io.Serializable {
        private double annualInterestRate;
        private int numberOfYears;
        private double loanAmount;
        private java.util.Date loanDate;

        public Loan(double annaulInterestRate, int numberOfYears, double loanAmount) {
            this.annualInterestRate = annaulInterestRate;
            this.numberOfYears = numberOfYears;
            this.loanAmount = loanAmount;
            loanDate = new java.util.Date();
        }

        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        public int getNumberOfYears() {
            return numberOfYears;
        }

        public void setNumberOfYears(int numberOfYears) {
            this.numberOfYears = numberOfYears;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public double getMonthlyPayment() {
            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 -(Math.pow(1/ (1 + monthlyInterestRate), numberOfYears * 12)));
            return monthlyPayment;
        }

        public double getTotalPayment() {
            double totalPayment = getMonthlyPayment() * numberOfYears * 12;
            return totalPayment;
        }

        public java.util.Date getLoanDate() {
            return loanDate;
        }



}

}
