package com.pluralsight;

public class LedgerView {

    public void enterTransactionName() {
        System.out.println("Enter the transaction file name (e.g., transactions.csv): ");
    }

    public void transactionChoice(String text) {
        System.out.println("Input transaction " + text + ": ");
    }
}

