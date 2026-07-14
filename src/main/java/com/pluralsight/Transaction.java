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
    public LocalDate getDate() {return this.transactionDate;}
    public LocalTime getTime() {return this.transactionTime;}
    public double getAmount() {return this.transactionAmount;}
    public String getDescription() {return this.description;}
    public String getVendor() {return this.vendor;}
    // setters
    public void setId(int id) {this.id = id;}
    public void setDate(LocalDate localDate) {this.transactionDate = localDate;}
    public void setTime(LocalTime localTime) {this.transactionTime = localTime;}
    public void setAmount(double transactionAmount) {this.transactionAmount = transactionAmount;}
    public void setDescription(String description) {this.description = description;}
    public void setVendor(String vendor) {this.vendor = vendor;}


}
