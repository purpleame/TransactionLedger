package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private int id;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private double transactionAmount;
    private String description;
    private String vendor;

    // getters
    public int getId() {return id;}
    public LocalDate getDate() {return transactionDate;}
    public LocalTime getTime() {return transactionTime;}
    public double getAmount() {return transactionAmount;}
    public String getDescription() {return description;}
    public String getVendor() {return vendor;}
    // setters
    public void setId(int id) {this.id = id;}
    public void setDate(LocalDate localDate) {this.transactionDate = transactionDate;}
    public void setTime(LocalTime localTime) {this.transactionTime = transactionTime;}
    public void setAmount(double transactionAmount) {this.transactionAmount = transactionAmount;}
    public void setDescription(String description) {this.description = description;}
    public void setVendor(String vendor) {this.vendor = vendor;}
}
