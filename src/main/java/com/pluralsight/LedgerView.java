package com.pluralsight;

public class LedgerView {

    public void welcomeScreen() {

    }

    public void enterTransactionName() {
        System.out.println("Enter the transaction file name (e.g., transactions.csv): ");
    }

    public void promptFor(String text) {
        System.out.println("Input transaction " + text + ": ");
    }

    public void transactionAddedSuccessfully(int id) {
        System.out.println("Transaction " + id + " added successfully!");
    }

    public void stopOrContinue() {
        System.out.println("");
    }

    public void invalidInput(String type) {
        System.out.println("Invalid " + type + " format. Please try again.");

    }
}

