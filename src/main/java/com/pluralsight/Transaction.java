package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private double transactionAmount;
    private String description;
    private String vendor;

    // getters
    public LocalDate getLocalDate() {return transactionDate;}
    public LocalTime getTransactionTime() {return transactionTime;}
    public double getTransactionAmount() {return transactionAmount;}
    public String getDescription() {return description;}
    public String getVendor() {return description;}
    // setters
    public void setTransactionDate(LocalDate localDate) {this.transactionDate = transactionDate;}
    public void setTransactionTime(LocalTime localTime) {this.transactionTime = transactionTime;}
    public void setTransactionAmount(double transactionAmount) {this.transactionAmount = transactionAmount;}
    public void setDescription(String description) {this.description = description;}
    public void setVendor(String vendor) {this.vendor = vendor;}
}
